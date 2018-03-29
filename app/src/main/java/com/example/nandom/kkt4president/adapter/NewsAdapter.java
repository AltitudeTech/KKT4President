package com.example.nandom.kkt4president.adapter;

import com.example.nandom.kkt4president.R;
import com.example.nandom.kkt4president.app.AppController;
import com.example.nandom.kkt4president.classes.News;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class NewsAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<News> newsItems;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public NewsAdapter(Activity activity, List<News> newsItems) {
		this.activity = activity;
		this.newsItems = newsItems;
	}

	@Override
	public int getCount() {
		return newsItems.size();
	}

	@Override
	public Object getItem(int location) {
		return newsItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.news_model, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();

		TextView tvTitle = (TextView) convertView.findViewById(R.id.newsTitle);
		TextView tvDate = (TextView) convertView.findViewById(R.id.tvTimeModified);

		News item = newsItems.get(position);

		String strLength = item.getTitle();

		if(strLength.length() > 55){
			strLength += ". . .";
		}

		tvTitle.setText(strLength);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		try {
			long time = sdf.parse(item.getDate()).getTime();

		// Converting timestamp into x ago format
		CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
				time,
				System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
		tvDate.setText(timeAgo);
	} catch (ParseException e) {
		e.printStackTrace();
	}

		return convertView;
	}

}
