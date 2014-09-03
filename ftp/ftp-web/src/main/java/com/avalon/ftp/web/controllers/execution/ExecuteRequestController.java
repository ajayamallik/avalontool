package com.avalon.ftp.web.controllers.execution;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avalon.ftp.beans.admin.MigrationFlowBean;
import com.avalon.ftp.beans.approvals.ApprovalBean;
import com.avalon.ftp.beans.approvals.ApprovalRequestBean;
import com.avalon.ftp.beans.environment.EnvironmentBean;
import com.avalon.ftp.services.approval.ApprovalService;
import com.avalon.ftp.web.controllers.approval.ApprovalController;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.UserInfo;




@Controller
public class ExecuteRequestController {
	
	
	Logger logger = Logger.getLogger(ApprovalController.class);
	
	//@Autowired
	//ExecuteRequestService executeRequestService;
	
	@Autowired
	ApprovalService approvalService;
	
	//  This functionality is replace with FND Download and Upload functionalities.
	@RequestMapping("/ExecuteRequests123") //changed from  ExecuteRequests for FNDload Test
	public void executeRequestsSelected(@RequestParam("selValues") String selectedValuesforExecution,@ModelAttribute("approvedRequests") ApprovalRequestBean  approvalRequestBean,Model model){
		logger.info(selectedValuesforExecution+" @Entered into executeRequestsSelected controller");
		
		String[] idAndapprovalid = null;
		String[] parts = selectedValuesforExecution.split(",");
		
				
		
		for(int i = 0; i<parts.length; i++){
			idAndapprovalid = parts[i].split("-");
			//getting migration flow name from approval POJO
			// id -approvalid - objecttype - path
			
			List<ApprovalBean> migrationFlow = approvalService.getMigratioFlow(idAndapprovalid[1]);
		
			// based on migration flow name , getting INSTANCE ID AND SEQUENCE etc...
			MigrationFlowBean instanceId = approvalService.getInstanceId(migrationFlow.get(0).getMigrationflow());
		
			//based on instance id, getting host,port etc..
			EnvironmentBean envDetails = approvalService.getEnvDetails(instanceId.getInstanceid());
			
			logger.info("Env Details in controller  host  "+envDetails.getHost());	
			logger.info("Env Details in controller  Port"+envDetails.getPort());
			logger.info("Env Details in controller  Sid"+envDetails.getSid());
			logger.info("-=-=-=-=-=-="+idAndapprovalid[2]);
			
			 //to create directories in server.
			String[] dirnames = idAndapprovalid[2].split(" ");
			String dirname = dirnames[0] +dirnames[1];
			logger.info("-=-=-=-= _"+dirname);
			
			
				if(idAndapprovalid[2].trim().equals("Oracle Forms".trim())){
					try{
						//Conversion String To File Type 
						File file = new File("C:/Users/Avlon/Desktop/"+idAndapprovalid[3]);	
						logger.info("-=-=-=-path=-=-=-=-=-="+file.getAbsolutePath()); //gets complete path with file name
						logger.info("-=-=-=-=name-=-=-=-=-=-="+file.getName());  // gets file name with extension only
						logger.info("-=-=-=-=-size=-=-=-=-=-=-="+file.length()); // file size
						logger.info("-=-=-=-=-=parent file-=-=-=-=-=-="+file.getParentFile()); // gets only path
			
						String filetotransfer = file.getAbsolutePath();					 
			
						int k = execute_Oracle_Forms(filetotransfer,dirname);
						logger.info("-=-=-=-=  "+k);
						}
							catch(Exception e){}
					}
		
			} // for loop END
	}

	
	

	@SuppressWarnings("null")
	private int execute_Oracle_Forms(String filetotransfer,String dirname) {
		// TODO Auto-generated method stub
		  logger.info("it is in oracle forms");	

		  String user = "root";  
		  String host = "192.168.100.100";  
		  
		  SftpATTRS attrs=null;		  
		 
		  
		 // String SFTPWORKINGDIR = "/oraAS/oracle/VIS/apps/apps_st/appl/po/12.0.0/reports/US/";
		  logger.info("-=-=-=-dirname "+dirname);
		  String SFTPWORKINGDIR = "/home/applmgr/";
		  Session     session     = null;
		  Channel     channel     = null;
		  ChannelSftp channelSftp = null;		  
		  
		  try{
	            JSch jsch = new JSch();
	            session = jsch.getSession(user,host,22);
	            	            
	            session.setPassword("redhat");
	            java.util.Properties config = new java.util.Properties();
	            logger.info("-=-=-=Conecting to server-=-=-in uploading=-=");	           	            
	            
	            config.put("StrictHostKeyChecking", "no");
	            session.setConfig(config);
	            session.connect();
	            logger.info("-=-=-1-=-=");
	            channel = session.openChannel("sftp");
	            channel.connect();
	            logger.info("-=-=-1-=-=");
	            channelSftp = (ChannelSftp)channel;
	            //channelSftp.mkdir(SFTPWORKINGDIR);
	            channelSftp.cd(SFTPWORKINGDIR);
	            logger.info("-=-=-1-=-=");
	            
	            File f = new File(filetotransfer);
	            logger.info("-=-=-1-=-="+f.getName());
	            channelSftp.put(new FileInputStream(f), f.getName());
	            logger.info("-=-=file transferred-=-=-");
				
		  }catch(Exception ex){
			  					ex.printStackTrace();
		  						}

          
			  logger.info("you have uploaded file successfully");
		 
				return 1;
	 	
	}  
	
		
	
	
	//Test for FND DOWNLOAD
	
	//@RequestMapping("/ExecuteRequestsFNDDownload")
	public String ExecuteRequestsFNDDownload(String parts,ApprovalRequestBean  approvalRequestBean,Model model,String serverName){
		String[] idAndapprovalid = null;
		logger.info("-=-=server name "+ serverName);
		idAndapprovalid = parts.split("-");
		EnvironmentBean envDetails = approvalService.getEnvDetailsByInstanceName(serverName);
		
		logger.info("Env Details in controller  host  "+envDetails.getHost());	
		logger.info("Env Details in controller  Port"+envDetails.getPort());
		logger.info("Env Details in controller  Sid"+envDetails.getSid());
		logger.info("Env Details in controller  instance Name"+envDetails.getInstancename());			
			
			String host = envDetails.getHost();
			int port = Integer.parseInt(envDetails.getPort());
			String sid = envDetails.getSid();
			String ldt_fineName = idAndapprovalid[4]+".ldt";
			String shrtName = idAndapprovalid[5];
			String CPname = "POXDETIT";  //concurrent program Name short Name  
			
			logger.info("short name : "+shrtName);
			logger.info(" C Program Name "+CPname);
			logger.info(" ldt Name "+ldt_fineName);
			String user="applmgr";
	        String password="applmgr";
	        
	        try{
	             
	            java.util.Properties config = new java.util.Properties(); 
	            config.put("StrictHostKeyChecking", "no");
	            JSch jsch = new JSch();
	            Session session=jsch.getSession(user, host, port);
	            session.setPassword(password);
	            session.setConfig(config);
	            session.connect();
	            logger.info("Connected");
	            //String download="FNDLOAD apps/apps 0 Y DOWNLOAD '/oraAS/oracle/VIS/apps/apps_st/appl/fnd/12.0.0/patch/115/import/afcpprog.lct' tipupathi.ldt PROGRAM CONCURRENT_PROGRAM_NAME='XX_PREPAYMENT_RESULT_REPORT' APPLICATION_SHORT_NAME='SQLAP'";  
	            Channel channel=session.openChannel("exec");
	            //Arguments can pass to .sh file by concate with setCommand argument and 
	            // use by $ in .sh file. 
	            //String param = "afcpprog.lct";
	            String param = "Ajaya1.lct";
	            String param1 = "afcpprog.lct";
	            
	           // System.out.println("-=-=repoShortName-=-"+repoShortName);
	            //((ChannelExec)channel).setCommand("./setting_enviranment.sh");
	            ((ChannelExec)channel).setCommand("./setting_enviranment.sh "+" "+ldt_fineName+" "+CPname+" "+shrtName);
	            channel.setInputStream(null);
	            ((ChannelExec)channel).setErrStream(System.err);
	             
	            InputStream in=channel.getInputStream();
	            channel.connect();
	            byte[] tmp=new byte[1024];
	            while(true){
	              while(in.available()>0){
	            	  
	                int ii = in.read(tmp, 0, 1024);
	                if(ii<0)break;
	                //logger.info(new String(tmp, 0, i));
	              }
	              if(channel.isClosed()){
	                logger.info("exit-status: "+channel.getExitStatus());
	                if(channel.getExitStatus() == 0) {
	                	int runstat = approvalService.changeApprovalStatusToRun(idAndapprovalid[0]);
	                	logger.info("-=-=Running Status "+idAndapprovalid[0]); 
	                }
	                 //downloadStatus = channel.getExitStatus();
	                break;
	              }
	              try{Thread.sleep(1000);}catch(Exception ee){}
	            }
	            channel.disconnect();
	            session.disconnect();
	            logger.info("DONE");
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        
			
			
			 //to create directories in server.
			String[] dirnames = idAndapprovalid[2].split(" ");
			String dirname = dirnames[0] +dirnames[1];

			
			File files = new File("D:\\FND\\DOWNLOAD\\"+serverName);
			
			if (files.exists()) {
				if (files.mkdirs()) {
					logger.info("Multiple directories are created!");
					logger.info("-=-=-=-=copying file name is   "+ldt_fineName);
				} else {
					logger.info("Failed to create multiple directories!");
					logger.info("-=-=-=-=copying file name is   /home/applmgr/"+ldt_fineName);
					copyingfromSeverToLocal(ldt_fineName,"localPath",serverName);
				}
			} else {
				boolean success = files.mkdirs();
				if (success) {
	                logger.info("Successfully created new directory : %s%n"+ serverName);
	                logger.info("-=-=-=-=copying file name is   /home/applmgr/"+ldt_fineName);
	                copyingfromSeverToLocal(ldt_fineName,"localPath",serverName);
	            } else {
	                logger.info("Failed to create new directory: %s%n"+ serverName);
	            }
				
			}
			logger.info("-=-=-=-= Download successfull-=-=-=");
			
			// FND Load Functionality 
			
			
			
				/*if(idAndapprovalid[2].trim().equals("Oracle Forms".trim())){
					try{
						//Conversion String To File Type 
						File file = new File("C:/Users/Avlon/Desktop/"+idAndapprovalid[3]);	
						logger.info("-=-=-=-path=-=-=-=-=-="+file.getAbsolutePath()); //gets complete path with file name
						logger.info("-=-=-=-=name-=-=-=-=-=-="+file.getName());  // gets file name with extension only
						logger.info("-=-=-=-=-size=-=-=-=-=-=-="+file.length()); // file size
						logger.info("-=-=-=-=-=parent file-=-=-=-=-=-="+file.getParentFile()); // gets only path
			
						String filetotransfer = file.getAbsolutePath();				 
			

						}
							catch(Exception e){}
					}*/
		

		//List<ApprovalRequestBean> pendingList = approvalService.getPendingApprovals("A");		  
		//model.addAttribute("pendingList", pendingList);
		return "1";
	}
	
	// FND DOWNLOAD END
	
	
	// copying file from remote to local system
			private void copyingfromSeverToLocal(String remotePath, String localPath,String instanceName) {
				logger.info("-=-=-=-=-=-=-=Entered into copy format-=-=-=-=");
			// TODO Auto-generated method stub
				Session session = null;
				  ChannelSftp channelSftp = null;
				  try {
				    final JSch jsch = new JSch();
				    final String user = "root"; // input.substring(0, indexOfAt);
				    final String host = "192.168.100.100"; //input.substring(indexOfAt + 1, indexOfColon);
				    final int port = 22	; //Integer.parseInt(input.substring(indexOfColon + 1));
				    // if you have set up authorized_keys on the server, using that identitiy
				    // with the code on the next line allows for password-free, trusted connections
				    // jsch.addIdentity("/path/to/id_rsa", "id_rsa_password");
				    session = jsch.getSession(user, host, 22);
				    session.setPassword("redhat");
				    java.util.Properties config = new java.util.Properties();
		            
		            config.put("StrictHostKeyChecking", "no");
		            session.setConfig(config);
		            session.connect();

				    //final UserInfo ui = new MyUserInfo();
				    //session.setUserInfo(ui);
				    //session.connect();
				    channelSftp = (ChannelSftp) session.openChannel("sftp");
				    channelSftp.connect();
				    channelSftp.get("/home/applmgr/"+remotePath, "D:/FND/DOWNLOAD/"+instanceName+"/"+remotePath);
				  } catch (JSchException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SftpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				    if (channelSftp != null) {
				      channelSftp.exit();
				    }
				    if (session != null) {
				      session.disconnect();
				    } 
				  }
			
		}



	
	
	
	//Test for FND UPLOAD
	

		//@RequestMapping("/ExecuteRequestsFNDUpload")
		public String executeRequestforFNDUpload(String parts,ApprovalRequestBean  approvalRequestBean,Model model,String serverName){
			
			String[] idAndapprovalid = null;
			
				idAndapprovalid = parts.split("-");
				EnvironmentBean envDetails = approvalService.getEnvDetailsByInstanceName(serverName);
				
				logger.info("Env Details in controller  host  "+envDetails.getHost());	
				logger.info("Env Details in controller  Port"+envDetails.getPort());
				logger.info("Env Details in controller  Sid"+envDetails.getSid());
				logger.info("Env Details in controller  instance Name"+envDetails.getInstancename());				
				
				String host = envDetails.getHost();
				int port = Integer.parseInt(envDetails.getPort());
				String sid = envDetails.getSid();
				String ldt_fineName = "D:/FND/DOWNLOAD/localserver/"+idAndapprovalid[4]+".ldt";
				String ldtfile = idAndapprovalid[4]+".ldt";
				String shrtName = idAndapprovalid[5];
				String CPname = "EMPLOYEE_INFORMATION";  //concurrent program Name. 
				
				
				String user="applmgr";
		        String password="applmgr";
		        String serverPath = "/home/applmgr/";
		        //moving .ldt file to server location
		        execute_Oracle_Forms( ldt_fineName, serverPath);
		        
		        try{
		             
		            java.util.Properties config = new java.util.Properties(); 
		            config.put("StrictHostKeyChecking", "no");
		            JSch jsch = new JSch();
		            Session session=jsch.getSession(user, host, port);
		            session.setPassword(password);
		            session.setConfig(config);
		            session.connect();
		            logger.info("Connected");
		            //String download="FNDLOAD apps/apps 0 Y DOWNLOAD '/oraAS/oracle/VIS/apps/apps_st/appl/fnd/12.0.0/patch/115/import/afcpprog.lct' tipupathi.ldt PROGRAM CONCURRENT_PROGRAM_NAME='XX_PREPAYMENT_RESULT_REPORT' APPLICATION_SHORT_NAME='SQLAP'";  
		            Channel channel=session.openChannel("exec");
		            //Arguments can pass to .sh file by concate with setCommand argument and 
		            // use by $ in .sh file. 
		            //String param = "afcpprog.lct";
		            //String param = "Ajaya1.lct";	            
		            
		           // System.out.println("-=-=repoShortName-=-"+repoShortName);
		            //((ChannelExec)channel).setCommand("./setting_enviranment.sh");
		           // ((ChannelExec)channel).setCommand("./setting_enviranment.sh "+" "+ldt_fineName+" "+CPname+" "+shrtName);
		            
		            ((ChannelExec)channel).setCommand("./setting_environ_up.sh "+ldtfile);
		            channel.setInputStream(null);
		            ((ChannelExec)channel).setErrStream(System.err);
		             
		            InputStream in=channel.getInputStream();
		            channel.connect();
		            byte[] tmp=new byte[1024];
		            while(true){
		              while(in.available()>0){
		            	  
		                int ii = in.read(tmp, 0, 1024);
		                if(ii<0)break;
		               // logger.info(new String(tmp, 0, i));
		              }
		              if(channel.isClosed()){
		                logger.info("exit-status: "+channel.getExitStatus());
		                if(channel.getExitStatus() == 1){
		                	int runstat = approvalService.changeApprovalStatusToRun(idAndapprovalid[0]);
		                	logger.info("-=-=Running Status "+idAndapprovalid[0]); }
		                	break;
		              }
		              try{Thread.sleep(1000);}catch(Exception ee){}
		            }
		            channel.disconnect();
		            session.disconnect();
		            logger.info("DONE");
		        }catch(Exception e){
		            e.printStackTrace();
		        }
		        
				
				 //to create directories in server.
				String[] dirnames = idAndapprovalid[2].split(" ");
				String dirname = dirnames[0] +dirnames[1];
				logger.info("-=-=-=-= UPLOAD SUCCESSFUl_");
			
			//List<ApprovalRequestBean> pendingList = approvalService.getPendingApprovals("A");		  
			//model.addAttribute("pendingList", pendingList);
			
			return "1";
		}
		
		// FND UPLOAD END
	
	
		
		
		
		@RequestMapping("/ExecuteRequests") //changed from  ExecuteRequests for FNDload Test
		public String executeRequests(@RequestParam("selValues") String selectedValuesforExecution,@ModelAttribute("approvedRequests") ApprovalRequestBean  approvalRequestBean,Model model){
			logger.info(" @Entered into executeRequestsSelected controller");
			
			String[] idAndapprovalid = null;
			String[] parts = selectedValuesforExecution.split(",");
			String[] instancenames= null;
					
			
			for(int i = 0; i<parts.length; i++){
				idAndapprovalid = parts[i].split("-");
				
				//1. getting Server Details to get environment details 
				String instanceNames = approvalService.getInstanceNames(idAndapprovalid[1]);
				logger.info("-=-=instance names "+instanceNames);
				String[] requestServer =  instanceNames.split(",");
				 	for(int rq = 0;rq < requestServer.length; rq++){
					  
				 		//based on instance name  getting environment details host,port etc..
				 		// param envDetails - represents all environmental details 
				 		logger.info("@requestserver[i] "+requestServer[rq]);
						EnvironmentBean envDetails = approvalService.getEnvDetailsByInstanceName(requestServer[rq]); 
						//param  reqType - represents UPLOAD or DOWNLOAD type ie U or D from Approval
						String reqType  = approvalService.getRequestType(idAndapprovalid[1]);
						logger.info("-=-=-=-=-=request Type-=-="+ reqType);
						if( reqType.equals("U")){
							logger.info("-=-=-=UPLOAD");
							executeRequestforFNDUpload(parts[i],approvalRequestBean,model,requestServer[rq]);
							
						}else if(reqType.equals("D")){
							logger.info("-=-=DOWNLOAD");
							ExecuteRequestsFNDDownload(parts[i],approvalRequestBean,model,requestServer[rq]);
						}
					 
				 	}
				

				} // for loop END
			List<ApprovalRequestBean> pendingList = approvalService.getPendingApprovals("A");		  
			model.addAttribute("pendingList", pendingList);
			
			 return "ApprovedRequest";

		}

		
	
	
	
	public static class MyUserInfo implements UserInfo {  
		  public String getPassword() {  
		   return "PASSWORD";  
		  }  
		  
		  public String getPassphrase() {  
		   return "";  
		  }  
		  
		  public boolean promptPassword(String arg0) {  
		   return true;  
		  }  
		  
		  public boolean promptPassphrase(String arg0) {  
		   return true;  
		  }  
		  
		  public boolean promptYesNo(String arg0) {  
		   return true;  
		  }  
		  
		  public void showMessage(String arg0) {  
		  }  
		  
		}
	
	
	

} 


