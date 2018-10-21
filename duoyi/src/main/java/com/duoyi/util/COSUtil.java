package com.duoyi.util;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.UploadResult;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.Download;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.Upload;

public class COSUtil {

	// 初始化秘钥信息
	private final static long appId = 1254133551;
	private final static String secretId = "AKIDssgIDoVcWefaP7y0FIArPnzFZjhzr991";
	private final static String secretKey = "oQq9OTN8j8LSWhhV7YEnBQTL4adaO3Zv";
	// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
	private final static String bucketName = "duoyi-" + appId;
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm ss");
	private final static String urlhead = "https://duoyi-1254133551.cos.ap-guangzhou.myqcloud.com/";

	// 获取cos客户端
	public static COSClient getCOSClient() {
		// 1 初始化用户身份信息(secretId, secretKey)
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		// 2 设置bucket的区域, COS地域的简称请参照
		// https://cloud.tencent.com/document/product/436/6224
		// clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法,
		// 使用可参见源码或者接口文档FAQ中说明
		ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
		// 3 生成cos客户端
		COSClient cosclient = new COSClient(cred, clientConfig);
		return cosclient;
	}

	// 关闭
	public static void closeCOSClient(COSClient CosClient) {
		CosClient.shutdown();
	}

	/*	上传文件
	 *  filename:具体名称
	 *  file：本地地址
	 */
	public static void Upload(COSClient CosClient, String file) {
		ExecutorService threadPool = Executors.newFixedThreadPool(32);
		// 传入一个 threadpool, 若不传入线程池, 默认 TransferManager 中会生成一个单线程的线程池。
		TransferManager transferManager = new TransferManager(CosClient, threadPool);

		try {
			
			File localFile = new File(file);
			String key = StringUtils.getRandomString(30)+"."+ StringUtils.splitByPot(localFile.getName());
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
			// 本地文件上传
			Upload upload = transferManager.upload(putObjectRequest);
			// 等待传输结束（如果想同步的等待上传结束，则调用 waitForCompletion）
			UploadResult uploadResult = upload.waitForUploadResult();
			String url = urlhead + key +"."+ StringUtils.splitByPot(localFile.getName());
//			String url = CosClient.generatePresignedUrl(bucketName + "-" + appId, key,
//					new Date(new Date().getTime() + 5 * 60 * 10000)).toString();
			System.out.println(url);
		} catch (CosServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CosClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			transferManager.shutdownNow();
			CosClient.shutdown();
		}
	}

	/* 暂时废除
	 * 下载文件
	 * filename:具体名称
	 *  file：本地地址
	 */
	public static void download(COSClient CosClient, String file, String filename) {
		ExecutorService threadPool = Executors.newFixedThreadPool(32);
		// 传入一个 threadpool, 若不传入线程池, 默认 TransferManager 中会生成一个单线程的线程池。
		TransferManager transferManager = new TransferManager(CosClient, threadPool);

		try {
			String key = filename;
			File localDownFile = new File(file);
			GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
			// 下载文件
			Download download = transferManager.download(getObjectRequest, localDownFile);
			// 等待传输结束（如果想同步的等待上传结束，则调用 waitForCompletion）
			download.waitForCompletion();
		} catch (CosClientException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			transferManager.shutdownNow();
			CosClient.shutdown();
		}

	}

	public static void delete(COSClient CosClient, String filename) {
		// 指定要删除的 bucket 和对象键
		CosClient.deleteObject(bucketName, filename);
		CosClient.shutdown();
	}
	
	public static void main(String[] args) {
		COSClient CosClient = getCOSClient();
		Upload(CosClient, "C:\\Users\\jydf\\Desktop\\1.txt");
	}
}
