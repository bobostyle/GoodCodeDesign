package com.zte.test.springaop.proxy.staticproxy;

 /**
 * Calculate.java
 * 2017年3月26日下午4:31:48
 * @author cbb
 * TODO
 */
public interface Calculate {
	void calculate(); // 这是一个处理千万级数据的计算接口，现在想对这个接口进行监控,统计出
	//每个接口的耗时.
}
