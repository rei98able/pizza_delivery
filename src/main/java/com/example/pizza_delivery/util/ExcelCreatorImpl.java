package com.example.pizza_delivery.util;

import com.example.pizza_delivery.model.ClientEntity;
import com.example.pizza_delivery.model.PizzaEntity;
import com.example.pizza_delivery.model.ZakazEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Slf4j
@Component
public class ExcelCreatorImpl implements ExcelCreatorInterface {

    @SneakyThrows
    @Override
    @Transactional
    public  String createExcel(
            String fileName,
            List<ClientEntity> clientEntities
    ) {
        String sheetName = "Отчет по пользователю";
        Workbook workbook;
        String path = "src//main//resources//Excel";
        if (fileName.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (fileName.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new RuntimeException("invalid file name, should be xls or xlsx");
        }


        FileOutputStream fileOutputStream = new FileOutputStream(new File(path, fileName));

        Sheet sheet = workbook.createSheet("Отчет по клиентам");
        Iterator<ClientEntity> iterator = clientEntities.iterator();
        int rowIndex = 0;
        sheet.createRow(rowIndex).createCell(0).setCellValue("Логин");
        sheet.getRow(rowIndex).createCell(1).setCellValue("Email");
        sheet.getRow(rowIndex).createCell(2).setCellValue("Заказы");
        rowIndex++;
        while (iterator.hasNext()) {
            ClientEntity clientEntity = iterator.next();
            sheet.createRow(rowIndex).createCell(0).setCellValue(clientEntity.getLogin());
            sheet.getRow(rowIndex).createCell(1).setCellValue(clientEntity.getEmail());
            List<ZakazEntity> zakazEntity = clientEntity.getZakazEntity();

            Cell orderCell= sheet.getRow(rowIndex).createCell(2);
            String result = "";
            for (ZakazEntity orders : zakazEntity) {
                List<PizzaEntity> pizzas = orders.getPizza();
                 result += orders.getId()+" Адрес:"+orders.getAddress() + " ФИО:" + orders.getName() + " Статус:" + orders.getStatus() + " Пицца:"+pizzas.stream()
                         .map(PizzaEntity::getName).collect(Collectors.joining())+"\n";
                 System.out.println(result);
            }
            orderCell.setCellValue(result);
            rowIndex++;
        }
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        return "Excel file created "+fileName;
    }
}
