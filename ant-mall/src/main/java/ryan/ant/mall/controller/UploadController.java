package ryan.ant.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UploadController {
    /* 默认文件路径设置*/
    private final static String FILE_UPLOAD_PATH = "D:\\Java\\UploadFile\\";

    @PostMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "上传失败";
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        /* Todo 生成文件通用方法*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random random = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(random.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        try {
            //保存文件
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FILE_UPLOAD_PATH + newFileName);
            Files.write(path, bytes);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "上传成功，地址为：" + FILE_UPLOAD_PATH + newFileName;
    }

    @PostMapping("/uploadFilesBySameName")
    @ResponseBody
    public String uploadFileBySameName(@RequestPart MultipartFile[] files){
        if(files == null || files.length == 0){
            return "参数异常";
        }
        if(files.length > 5){
            return "最多上传5个文件";
        }
        String uploadResult = "上传成功，地址为：<br>";
        for(MultipartFile file: files){
            String fileName = file.getOriginalFilename();
            if(StringUtils.isEmpty(fileName)){
                continue;   //表示无文件信息，故跳出循环
            }
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            /* Todo  生成文件名称的通用方法*/
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Random random = new Random();
            StringBuilder tempName = new StringBuilder();
            tempName.append(sdf.format(new Date())).append(random.nextInt(100)).append(suffixName);
            String newFileName = tempName.toString();
            try {
                //保存文件
                byte[] bytes = file.getBytes();
                Path path = Paths.get(FILE_UPLOAD_PATH + newFileName);
                Files.write(path, bytes);
                uploadResult += "/upload/" + newFileName + "<br>";
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return uploadResult;
    }

    @Autowired
    StandardServletMultipartResolver resolver;
    /*
      Todo 企业级项目中常遇到的文件上传情况
    **/
    @PostMapping("/uploadFilesByDifferentName")
    @ResponseBody
    public String uploadFilesByDifferentName(HttpServletRequest request){
        List<MultipartFile> multipartFiles = new ArrayList<>(8);
        /* TODO 参数校验*/
        //StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
        if(!resolver.isMultipart(request)){
            return "请选择文件";     //如果不是文件上传请求则不处理
        }
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iterator = multiRequest.getFileNames();
        int total = 0;
        while(iterator.hasNext()){
            if(total > 5){
                return "最多上传5个文件";
            }
            total += 1;
            MultipartFile file = multiRequest.getFile(iterator.next());
            multipartFiles.add(file);
        }
        if(CollectionUtils.isEmpty(multipartFiles)){
            return "请选择文件";
        }
        if(multipartFiles != null && multipartFiles.size() > 5){
            return "最多上传5个文件";
        }
        /* TODO 开始逻辑处理*/
        String uploadResult = "上传成功，地址为：<br>";
        for (int i = 0; i < multipartFiles.size(); i++) {
            String fileName = multipartFiles.get(i).getOriginalFilename();
            if(StringUtils.isEmpty(fileName)){
                continue;   //表示无文件信息，故跳出循环
            }
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            /* Todo  生成文件名称的通用方法*/
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Random random = new Random();
            StringBuilder tempName = new StringBuilder();
            tempName.append(sdf.format(new Date())).append(random.nextInt(100)).append(suffixName);
            String newFileName = tempName.toString();
            try {
                //保存文件
                byte[] bytes =  multipartFiles.get(i).getBytes();
                Path path = Paths.get(FILE_UPLOAD_PATH + newFileName);
                Files.write(path, bytes);
                uploadResult += "/upload/" + newFileName + "<br>";
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return uploadResult;
    }
}
