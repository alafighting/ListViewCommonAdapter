package com.liqi.listviewcommonadapter.adapter;

import java.util.Hashtable;
import java.util.List;

import com.liqi.listviewcommonadapter.port.AdapterAgencyInterface;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 *  所有ListViewItem通用BaseAdapter适配器的基类
 */
public class AdapterFather<T> extends BaseAdapter {
	protected List<T> data;// 此集合需要添加其他属性,可以在此对象里面去添加
	protected Context context;
	protected int layou;
	private int[] layouIds;
	private AdapterAgencyInterface<T> agencyInterface;

	/**
	 * 
	 * @param data
	 *            要展示的数据集合
	 * @param layouIds
	 *            item布局ID集合
	 * @param context
	 *            上下文
	 * @param layou
	 *            item布局
	 * @param agencyInterface
	 *            getView操作回调接口
	 * @throws Exception
	 *             如果（getView操作回调接口）为空就抛出此异常
	 */
	public AdapterFather(List<T> data, int[] layouIds, Context context,
			int layou, AdapterAgencyInterface<T> agencyInterface)
			throws Exception {
		this.data = data;
		this.context = context;
		this.layou = layou;
		this.layouIds = layouIds;
		if (agencyInterface != null)
			this.agencyInterface = agencyInterface;
		else
			throw new Exception();

	}

	@Override
	public int getCount() {
		return data == null ? 0 : data.size();
	}

	@Override
	public Object getItem(int position) {
		return data == null ? 0 : data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		T be = data.get(position);
		View view = null;
		AdapterInnerClass snf = null;
		if (convertView == null) {
			view = View.inflate(context, layou, null);
			snf = new AdapterInnerClass();
			for (int i = 0; i < layouIds.length; i++) {
				int clazz = layouIds[i];
				Object obj = view.findViewById(clazz);
				snf.obj.put(clazz, obj);
			}
			view.setTag(snf);
		} else {
			view = convertView;
			snf = (AdapterInnerClass) view.getTag();
		}
		agencyInterface.setViewData(snf, be);
		return view;
	}

	public class AdapterInnerClass {
		public final Hashtable<Integer, Object> obj = new Hashtable<Integer, Object>();
	}

	/**
	 * 用来更新List集合（可有可无）
	 * 
	 * @param data
	 */
	public void setData(List<T> data) {
		this.data.clear();
		if (data != null) {
			this.data.addAll(data);
		}
	}
}
