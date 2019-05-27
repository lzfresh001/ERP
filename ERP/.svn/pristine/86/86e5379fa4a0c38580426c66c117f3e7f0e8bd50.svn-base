package com.lzf.erp.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
 
/**
 * @comment 
 * @filename GeneratorSqlmap.java
 * @author lzf
 * @date 2019年4月7日 下午6:40:12
 * @version 1.0
 */
public class GeneratorSqlmap {
 
	// 执行main方法以生成代码
	/**
	 * @comment 
	 * @author lzf
	 * @date 2019年4月7日 下午6:40:17
	 * @param args
	 * @throws Exception
	 * @return void
	 * @version 1.0
	 */
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		// 指定配置文件
		File configFile = new File("config/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
}