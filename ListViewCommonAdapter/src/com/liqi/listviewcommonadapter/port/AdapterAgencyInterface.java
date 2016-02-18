package com.liqi.listviewcommonadapter.port;

import com.liqi.listviewcommonadapter.adapter.AdapterFather.AdapterInnerClass;


/**
 * 适配器回调接口
 * @author Administrator
 *
 * @param <T>
 */
public interface AdapterAgencyInterface <T>{
	@SuppressWarnings("rawtypes")
	public void setViewData(AdapterInnerClass adapterInnerClass,T t);
}
