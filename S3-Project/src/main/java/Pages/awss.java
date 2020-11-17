package Pages;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class awss {

	private static final String SUFFIX = "/";

	private static final String UNDERSCORE= "_";
	
	public void uploadfile(String f) {
		changeName(f);
	}
	static File ol;
	static File ne;
	public String changeName(String f){
		 ol=new File(f);
		
		//original filename
		 String new1="";
		 String mynew="";
		
			for(int i=0;i<f.length();i++) {
				if(String.valueOf(f.charAt(i)).equals("\\")){
					new1= "";
	
				}
				else {
					new1 = new1 + String.valueOf(f.charAt(i));
					
				}
					
			}
			
			//ne file name
			String new2="";
			String asid="1";
			String suid="3";
			String pre="";
			
			//extract suffix of file
			
			for(int i=0;i<new1.length();i++) {
				if(String.valueOf(new1.charAt(i)).equals(".")){
					pre= "";
					
					
				}
				else {
					pre = pre + String.valueOf(new1.charAt(i));
				}
					
			}
			
			new2= asid + UNDERSCORE + suid + "." + pre;

			mynew= f.substring(0,(f.length()-new1.length()));
			mynew=mynew+new2;


			
			 ne=new File(mynew);
			
			if(ol.renameTo(ne)) {

			//code for upload for "mynew"

			return (new2 +" "+ mynew).trim();
		}
	
			return (new2 +" "+ mynew).trim();
		
}
	
	
	public static void main(String[] args) {
		
		// user must have AWSConnector and AmazonS3FullAccess for 
		
//		AWSCredentials credentials = new BasicAWSCredentials(
//				"", 
//				"");
		
		// create a client connection based on credentials
//		AmazonS3 s3client = new AmazonS3Client(credentials);
		
		// create bucket - name must be unique for all S3 users
//		String bucketName = "mohan-876950-a";
//		s3client.createBucket(bucketName);
		
		// list buckets
//		for (Bucket bucket : s3client.listBuckets()) {
//			System.out.println(" - " + bucket.getName());
//		}
		
		// create folder into bucket
//		String folderName = "Section-A";
		//createFolder(bucketName, folderName, s3client);
		
		// upload file to folder and set it to public
//		String fileName = folderName + SUFFIX + "testvideo.mp4";
//		s3client.putObject(new PutObjectRequest(bucketName, fileName, 
//				new File("C:\\Users\\user\\Desktop\\testvideo.mp4"))
//				.withCannedAcl(CannedAccessControlList.PublicRead));
//		
	
		
		App ob=new App();
		
//		String filepath=ob.changeName("D:\\colleage\\javascrpt\\web\\button group.txt");
		String fname="";
		String fPath="";
//		for(int i=0;i<filepath.length();i++) {
//			if(!(String.valueOf(filepath.charAt(i)).equals(" "))){
//				fname= fname + String.valueOf(filepath.charAt(i));
//				
//				
//			}
//			else {
//				break;
//			}
//			
//		}
//		fPath=filepath.substring(fname.length(),filepath.length()).trim();

		
		
//		String fileName = folderName + SUFFIX + fname;
//		s3client.putObject(new PutObjectRequest(bucketName, fileName, 
//				new File(fPath))
//				.withCannedAcl(CannedAccessControlList.PublicRead));
		
		
		if(ne.renameTo(ol)) {

			///again rename;
		}
		
		//deleteFolder(bucketName, folderName, s3client);
		
		// deletes bucket
		//s3client.deleteBucket(bucketName);
	}
	
	public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);

		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
				folderName + SUFFIX, emptyContent, metadata);

		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}

	/**
	 * This method first deletes all the files in given folder and than the
	 * folder itself
	 */
//	public static void deleteFolder(String bucketName, String folderName, AmazonS3 client) {
//		List fileList = 
//				client.listObjects(bucketName, folderName).getObjectSummaries();
//		for (S3ObjectSummary file : fileList) {
//			client.deleteObject(bucketName, file.getKey());
//		}
//		client.deleteObject(bucketName, folderName);
//	}
}

