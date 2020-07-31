package com.springboot.excel.user.service.impl;

import com.springboot.excel.user.entity.User;
import com.springboot.excel.user.service.UserService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @作者 苏健勇
 * @创建时间 2020/7/29 15:27
 * @描述
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String export(String basePath, HttpServletResponse response) {

        InputStream inputStream = null;
        Workbook workBook = null;
        // 模板路径
//        String tempDir = basePath + "/user.xlsx";
//        File file = new File(tempDir);
        File file = new File(basePath);

        try {
            inputStream = new FileInputStream(file);
//            workBook = new HSSFWorkbook(inputStream);
            workBook = new XSSFWorkbook(inputStream);

            Sheet sheet = workBook.getSheetAt(0);
            if (sheet == null) {
                sheet = workBook.createSheet();
                Row row = sheet.createRow(0);
                row.createCell(0).setCellValue("用户标识");
                row.createCell(1).setCellValue("用户名称");
                row.createCell(2).setCellValue("用户头像");
                row.createCell(3).setCellValue("性别");
                row.createCell(4).setCellValue("手机号");
            }

            // 模拟数据
            List<User> userList = new ArrayList<>();
            User user1 = new User("001", "张三", "abc", 0, "12345678");
            User user2 = new User("002", "李四", "efg", 1, "87654321");
            userList.add(user1);
            userList.add(user2);
            int rowIndex = 1;
            for (User user : userList) {
                Row row = sheet.getRow(rowIndex);
                if (null == row) {
                    row = sheet.createRow(rowIndex);
                }
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getUserName());
                row.createCell(2).setCellValue(user.getHead());
                row.createCell(3).setCellValue(user.getSex() == 0 ? "男" : "女");
                row.createCell(4).setCellValue(user.getPhone());
                rowIndex++;
            }
            String fileName = "test.xlsx";
            downLoadExcel(fileName, response, workBook);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                inputStream.close();
                workBook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
