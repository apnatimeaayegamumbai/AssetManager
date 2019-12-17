package com.apnatimeaayega.assetmanager.utils;

import javax.sql.DataSource;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.stereotype.Component;

@Component
public class JooqUtils {

    private final DataSource dataSource;
    private final SQLDialect sqlDialect;

    public JooqUtils(DataSource dataSource, SQLDialect sqlDialect) {
        this.dataSource = dataSource;
        this.sqlDialect = sqlDialect;
    }

    public DSLContext getAtomicDSLContext() {
        Configuration config = getConfigurationFromDataSource();
        return DSL.using(config);
    }

    private Configuration getConfigurationFromDataSource() {
        return new DefaultConfiguration()
            .set(new DataSourceConnectionProvider(dataSource))
            .set(sqlDialect);
    }
}
