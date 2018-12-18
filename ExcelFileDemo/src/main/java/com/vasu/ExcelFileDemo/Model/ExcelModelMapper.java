/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.ExcelFileDemo.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author rv
 */
public class ExcelModelMapper implements RowMapper<ExcelModel> {

    private static final Logger logger = LoggerFactory.getLogger("ExcelModelMapper.class");

    @Override
    public ExcelModel mapRow(ResultSet rs, int i) throws SQLException {
        ExcelModel model = new ExcelModel();
        logger.info("i= " + i);
        model.setEmailid(rs.getString("EmailId"));
        model.setPassword(rs.getString("Password"));
        return model;
    }

}
