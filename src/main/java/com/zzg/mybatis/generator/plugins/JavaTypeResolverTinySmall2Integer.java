package com.zzg.mybatis.generator.plugins;

import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * @author hanakei
 * @since 2018/4/28
 */
public class JavaTypeResolverTinySmall2Integer extends JavaTypeResolverDefaultImpl {

    @Override
    protected FullyQualifiedJavaType overrideDefaultType(IntrospectedColumn column, FullyQualifiedJavaType defaultType) {
        FullyQualifiedJavaType answer = defaultType;

        switch (column.getJdbcType()) {
            // 如果是SMALLINT, TINYINT，则转化成Integer
            case Types.SMALLINT:
            case Types.TINYINT:
                answer = new FullyQualifiedJavaType(Integer.class.getName());
                break;
            default:
                break;
        }

        return answer;
    }
}
