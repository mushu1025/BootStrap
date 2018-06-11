package com.hsbc.test.controller;

public class ServiceController {

@RequestMapping(value = "/upload", method = RequestMethod.POST)
 @ResponseBody
 private Result importExcel(@RequestParam(value = "excelFile", required = false) MultipartFile file,HttpServletRequest request) {
     try {
         MultipartRequest multipartRequest=(MultipartRequest) request;
         MultipartFile excelFile=multipartRequest.getFile("excelFile");
         if(excelFile!=null){
             List<List<String>> datas = ExcelUtil.readXls(excelFile.getInputStream());
     //TODO: ���������ݶ���datas���棬����ʵ��ҵ���߼�����Ӧ����<br>                // .............
             if(datas!=null && datas.size()>0){
                 return new Result(true);
             }
         }else{
             return new Result(false);
         }
     } catch (Exception e) {
         return new Result(false,e.getMessage());
     }
     return new Result(false);
 }
}
