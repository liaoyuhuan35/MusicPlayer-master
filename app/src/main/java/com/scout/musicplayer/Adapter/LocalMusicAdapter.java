package com.scout.musicplayer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.scout.musicplayer.LOG;
import com.scout.musicplayer.R;
import com.scout.musicplayer.service.MusicInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaoyuhuan on 2016/7/21.
 */
public class LocalMusicAdapter extends BaseAdapter {
    private static final String TAG = "LocalMusicAdapter";

    private List<MusicInfo> sMusicList = new ArrayList<>();

    public void updateMusicList(List<MusicInfo> list){
        LOG.i(TAG, "updateMusicList ");
        sMusicList = list;
    }

    @Override
    public int getCount() {
        LOG.i(TAG, "getCount ");
        return sMusicList.size();
    }

    @Override
    public Object getItem(int position) {
        LOG.i(TAG, "getItem "+position);
        return sMusicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        LOG.i(TAG, "getItemId "+position);
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LOG.i(TAG, "getView "+position);
        ViewHolderLocalMusic holder;

        //getViewHolder
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_localmusic,parent,false);
            holder = new ViewHolderLocalMusic(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolderLocalMusic)convertView.getTag();
        }
        //update ViewHolderInfos
        final MusicInfo music = sMusicList.get(position);

        View vPlaying;
        ImageView ivCover;
        TextView tvTitle;
        TextView tvArtist;
        ImageView ivMore;
        View vDivider;

        LOG.i(TAG, "holder.tvTitle.setText "+music.title);
        holder.tvTitle.setText(music.title);


//        holder.ivCover.setImageBitmap(music.coverUri);


        return convertView;
    }


    class ViewHolderLocalMusic {
        View vPlaying;
        ImageView ivCover;
        TextView tvTitle;
        TextView tvArtist;
        ImageView ivMore;
        View vDivider;

        public ViewHolderLocalMusic(View view) {
            vPlaying = view.findViewById(R.id.v_playing);
            ivCover = (ImageView) view.findViewById(R.id.iv_cover);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvArtist = (TextView) view.findViewById(R.id.tv_artist);
            ivMore = (ImageView) view.findViewById(R.id.iv_more);
            vDivider = view.findViewById(R.id.v_divider);
        }
    }
}