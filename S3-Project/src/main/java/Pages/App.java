package Pages;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.Region;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class App {
	
	private static final String SUFFIX = "/";

	private static final String UNDERSCORE= "_";
	
//		AWSCredentials credentials = new BasicAWSCredentials(
//				"access key", 
//				"secret key");
		
//		AmazonS3 s3client = new AmazonS3Client(credentials);
	//AmazonS3 s3client= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();
	// create bucket - name must be unique for all S3 users
//		String bucketName = "mohan-876950-a";
//		s3client.createBucket(bucketName);
		

		
		// create folder into bucket
//		String folderName = "Section-A";
		//createFolder(bucketName, folderName, s3client);
		
		// upload file to folder and set it to public
//		String fileName = folderName + SUFFIX + "testvideo.mp4";
//		s3client.putObject(new PutObjectRequest(bucketName, fileName, 
//				new File("C:\\Users\\user\\Desktop\\testvideo.mp4"))
//				.withCannedAcl(CannedAccessControlList.PublicRead));
//		
	
		
	
		
		String filepath="D:\\colleage\\javascrpt\\web\\button group.txt";
		String fname="";
		String fPath="";
//		

//		fPath=filepath.substring(fname.length(),filepath.length()).trim();



}
