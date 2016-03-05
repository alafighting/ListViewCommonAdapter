package com.liqi.listviewcommonadapter.activity;

import java.util.ArrayList;
import java.util.List;

import com.liqi.listviewcommonadapter.R;
import com.liqi.listviewcommonadapter.adapter.AdapterFather;
import com.liqi.listviewcommonadapter.adapter.AdapterFather.AdapterInnerClass;
import com.liqi.listviewcommonadapter.port.AdapterAgencyInterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 如遇到有什么不懂的,可以QQ联系我
 * 
 * @author LiQi
 * @QQ:543945827
 * 
 */
public class MainActivity extends Activity implements
		AdapterAgencyInterface<String> {
	private ListView list_view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		list_view = (ListView) findViewById(R.id.list_view);
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < 50; i++) {
			data.add("好一朵美丽的茉莉花>>" + i + "" + i);
		}
		// Item布局里面的控件ID
		int id[] = { R.id.textview_id_one, R.id.textview_id_two };
		try {
			AdapterFather<String> adapter = new AdapterFather<String>(data, id,
					this, R.layout.adapter_list_item, this);
			list_view.setAdapter(adapter);
		} catch (Exception e) {
			Toast.makeText(this, "接口不能为空", 0).show();
		}
	}

	/**
	 * 适配器getView方法里面的接口回调
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setViewData(AdapterInnerClass adapterInnerClass, String t) {
		TextView textview_id_one = (TextView) adapterInnerClass.obj
				.get(R.id.textview_id_one);
		textview_id_one.setText(t);
		TextView textview_id_two = (TextView) adapterInnerClass.obj
				.get(R.id.textview_id_two);
		textview_id_two.setText(t);
	}
}
