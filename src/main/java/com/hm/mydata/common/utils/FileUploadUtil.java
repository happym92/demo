package com.hm.mydata.common.utils;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 1. ClassName : Fileupload
 * 2. FileName  : Fileupload.java
 * 3. Package   : kmds.com.framework.common.utils
 * 4. Comment   :
 * @author      : User
 * @version     : 2021. 12. 28. �삤�썑 5:23:19
 */
@Slf4j
@Service
public class FileUploadUtil {

//	@Value("${kmds.image.save.dir}")
//	private String imageNas;
//
//	@Value("${spring.profiles.active}")
//	private String svrMode;
//
//	@Value("${kmds.image.server.url}")
//	private String svrUrl;
//
//	@Value("${kmds.image.server.resources}")
//	private String svrImgSrc;
//
//	@Value("${kmds.file.max.size}")
//	private long fileSize;
//
//	@Value("${kmds.file.images.ext}")
//	private String imgExt;
//
//	@Value("${kmds.file.docs.ext}")
//	private String docExt;
//
//	/**
//	 * 1. MethodName        : upload
//	 * 2. ClassName         : FileUploadUtil
//	 * 3. Comment           : �떒嫄� 泥섎━
//	 * @author              : User
//	 * @version             : 2022. 4. 27. �삤�썑 1:17:37
//	 * @return List<FileVo>
//	 * @param request
//	 * @param file
//	 * @param dir
//	 * @return
//	 */
//	public List<FileVo> upload(HttpServletRequest request, MultipartFile file, String dir) {
//		MultipartFile[] files = { file };
//		return upload(request, files,dir);
//	}
//
//	/**
//	 * 1. MethodName        : upload
//	 * 2. ClassName         : FileUploadUtil
//	 * 3. Comment           :
//	 * @author              : User
//	 * @version             : 2022. 4. 27. �삤�썑 1:17:48
//	 * @return List<FileVo>
//	 * @param request
//	 * @param files
//	 * @param dir
//	 * @return
//	 */
//	public List<FileVo> upload(HttpServletRequest request, MultipartFile[] files, String dir) {
//
//		String imgSrc = svrImgSrc;
//		List<FileVo> fileVoList = new ArrayList<FileVo>();
//
//		// �뾽濡쒕뱶�븷 �뙆�씪�씠 議댁옱�븯吏� �븡�뒗 寃쎌슦
//		if(files == null || files.length == 0 || files[0].getSize() == 0) {
//			return Collections.emptyList();
//
//		// �뾽濡쒕뱶�븷 �뙆�씪�씠 議댁옱�븯�뒗 寃쎌슦
//		} else {
//			if("/".equals(imgSrc.substring(0,1))) {
//				imgSrc = imgSrc.substring(1);
//			}
//
//			int fileCnt = 0;
//			String fileNm = "";
//			String orgfileNm = "";
//			String fileExt = "";
//			String mkDir = "";
//			String saveDir1 = "";
//
//			// ���옣dir(�뾽臾댁퐫�뱶)
//			if("".equals(dir)) {
//				dir = "/temp/";
//			} else {
//				dir = "/" + dir + "/";
//			}
//
//			log.debug("imageNas + dir -->" + imageNas + dir);
//
//			Path path01 = Paths.get(imageNas + dir).toAbsolutePath();
//			if(!path01.toFile().isDirectory()) {
//				log.debug("mkdir_1 :" + path01.toString());
//				path01.toFile().mkdirs();
//			}
//
//			log.debug("svrUrl :" + svrUrl);
//			log.debug("imgSrc :" + imgSrc);
//
//			FileOutputStream fos = null;
//
//			for(MultipartFile file : files) {
//				if(!file.isEmpty()) {
//					fileCnt++;
//
//					FileVo fileVo = new FileVo();
//
//					orgfileNm = file.getOriginalFilename();
//					fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//					fileNm = UUID.randomUUID().toString().replaceAll("-", "") + fileExt;
//
//	                if(log.isDebugEnabled()) {
//	                	log.debug("�뾽濡쒕뱶 orgfileNm-->"  + orgfileNm + "<--" );
//	                	log.debug("�뾽濡쒕뱶 fileExt  -->"  + fileExt   + "<--" );
//	                	log.debug("�뾽濡쒕뱶 fileNm   -->"  + fileNm    + "<--" );
//	                	log.debug("�뾽濡쒕뱶 遺덇��뒫�븳 �솗�옣�옄 泥댄겕 1-->" + fileExtCheck(fileExt.substring(1).toString()) + "<--");
//	                }
//
//					if(!"".equals(fileExtCheck(fileExt.substring(1).toString()))) {
//						mkDir = dir + fileExtCheck(fileExt.substring(1).toString());
//
//					} else {
//						log.debug("�뾽濡쒕뱶 遺덇��뒫�븳 �솗�옣�옄 :" + fileExt);
//						throw new CustomException(ErrorCode.HTTP_ERROR_50102);
//						//return Collections.emptyList();
//					}
//
//					log.debug("mkDir :" + mkDir);
//
//					if("local".equals(svrMode)) {
//						String saveDir = request.getServletContext().getRealPath("");
//						saveDir = saveDir.replaceAll("\\\\", "/");
//						saveDir1 = saveDir + imgSrc + mkDir;
//					} else {
//						saveDir1 = imageNas + mkDir;
//					}
//
//					log.debug("imageNas :" + saveDir1);
//
//					Path path02 = Paths.get(saveDir1).toAbsolutePath();
//					if(!path02.toFile().isDirectory()) {
//						log.debug("mkdir_2 :" + path02.toString());
//						path02.toFile().mkdirs();
//					}
//
//					fileSizeCheck(fileExt, file.getSize());
//
//					fileVo.setUrl(svrUrl + "/" + imgSrc + mkDir + fileNm);      // �쎒�젒洹펥rl
//					fileVo.setFileRout(svrUrl + "/" + imgSrc + mkDir);      	// �쎒�젒洹� �뙆�씪 寃쎈줈
//					fileVo.setUploaded(fileCnt);			                    // �뙆�씪�뾽濡쒕뱶媛쒖닔
//					fileVo.setFileSize(file.getSize());                         // �뙆�씪�궗�씠利�
//					fileVo.setFileName(orgfileNm);                              // �뾽濡쒕뱶�뙆�씪紐�
//					fileVo.setSaveDir(saveDir1);                                // ���옣寃쎈줈
//					fileVo.setSaveFileName(fileNm);                             // ���옣�뙆�씪紐�
//					fileVo.setFileStatus("1");                                  // �긽�깭
//					fileVoList.add(fileVo);
//
//					try {
//
//						Path path = Paths.get(saveDir1 + fileNm).toAbsolutePath();
//						fos = new FileOutputStream(path.toFile());
//						fos.write(file.getBytes());
//						fos.flush();
//						fos.close();
//
//					} catch (FileNotFoundException e) {
//						log.debug(e.getMessage());
//
//					} catch (IllegalStateException e) {
//						log.debug(e.getMessage());
//
//					} catch (IOException e) {
//						log.debug(e.getMessage());
//
//					} finally {
//						if(fos != null) {
//							try { fos.close(); } catch (IOException e) {}
//						}
//					}
//				}
//			}
//
//			log.debug("fileVoList : {}", fileVoList);
//
//			return fileVoList;
//		}
//
//	}
//
//	/*
//	public ResponseEntity<Resource> download(HttpServletRequest request, String fileDir, String fileNm) {
//
//		String saveDir = request.getServletContext().getRealPath("");
//		saveDir = saveDir.replaceAll("\\\\", "/") + fileDir;
//
// 		Resource resource = null;
//		try {
//			resource = new InputStreamResource(new FileInputStream(saveDir));
//		} catch (FileNotFoundException e) {
//			log.debug("file download error :" + e.getMessage());
//			throw new CustomException(ErrorCode.HTTP_ERROR_50104);
//		}
//
//		File file = new File(saveDir);
//
//		String encfileNm = "";
//		try {
//			encfileNm = URLEncoder.encode(fileNm, "UTF-8");
//			encfileNm = encfileNm.replaceAll("\\+", "%20");
//		} catch (UnsupportedEncodingException e) {
//			log.debug("file download error :" + e.getMessage());
//		}
//
//		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + encfileNm)
//				 .contentLength(file.length())
//				 .contentType(MediaType.parseMediaType("appliction/octet-stream"))
//				 .body(resource);
//	}
//	*/
//
//	/**
//	 * 1. MethodName        : delete
//	 * 2. ClassName         : FileUploadUtil
//	 * 3. Comment           :
//	 * @author              : User
//	 * @version             : 2022. 4. 27. �삤�썑 1:18:59
//	 * @return String
//	 * @param request
//	 * @param file
//	 * @return
//	 */
//	public String delete(HttpServletRequest request, String file) {
//		String saveDir = request.getServletContext().getRealPath("");
//		String retStr = "";
//		saveDir = saveDir.replaceAll("\\\\", "/");
//
//		File saveFile = new File(saveDir + file);
//
//		if(saveFile.isFile()) {
//			saveFile.delete();
//			retStr = "1";
//		}
//
//		return retStr;
//	}
//
//	/**
//	 * 1. MethodName        : fileExtCheck
//	 * 2. ClassName         : FileUploadUtil
//	 * 3. Comment           :
//	 * @author              : User
//	 * @version             : 2022. 4. 27. �삤�썑 1:19:06
//	 * @return String
//	 * @param fileExt
//	 * @return
//	 */
//	private String fileExtCheck(String fileExt) {
//		String yyDir = "";
//		String retStr = "";
//
//		String[] imgExtSp = imgExt.split("\\|\\|");
//		for(String imgExtStr : imgExtSp) {
//			if( imgExtStr.equals( fileExt.toUpperCase()) || imgExtStr.equals(fileExt.toLowerCase())) {
//				log.debug("�씠誘몄� �솗�옣�옄 泥댄겕:" + fileExt);
//				retStr = "images";
//			}
//		}
//
//		if(!"".equals(retStr)) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//			Date date = new Date();
//			yyDir = sdf.format(date);
//
//			retStr = yyDir + "/";
//		}
//
//		log.debug("retStr : {}", retStr);
//
//		return retStr;
//	}
//
//	/**
//	 * 1. MethodName        : fileSizeCheck
//	 * 2. ClassName         : FileUploadUtil
//	 * 3. Comment           :
//	 * @author              : User
//	 * @version             : 2022. 4. 27. �삤�썑 1:19:15
//	 * @return void
//	 * @param ext
//	 * @param size
//	 */
//	private void fileSizeCheck(String ext, long size) {
//		if(!"xls".equals(ext.substring(1).toLowerCase()) && !"xlsx".equals(ext.substring(1).toLowerCase())) {
//			if(size > fileSize) {
//				log.debug("fileSizeCheck error || ext:" + ext + " || size:" + size);
//				throw new CustomException(ErrorCode.HTTP_ERROR_50103);
//			}
//		}
//	}

}
