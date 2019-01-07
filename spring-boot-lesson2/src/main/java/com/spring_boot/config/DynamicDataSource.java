package com.spring_boot.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by zhouchao on 19/1/4.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    private static transient Log log = LogFactory.getLog(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        log.debug("数据源为" + DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
