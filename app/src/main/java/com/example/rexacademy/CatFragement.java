package com.example.rexacademy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CatFragement extends Fragment {

    ImageView uploadVideo;

    ImageView card_video, card_book, card_podcast, card_news, card_magazine, card_comic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cat, container, false);



        //For Uploading Video Button
        uploadVideo = (ImageView) view.findViewById(R.id.upload_video);
        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), addVideo.class));
            }
        });




        // For Video Activity

        card_video = (ImageView) view.findViewById(R.id.video_activity);
        card_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), video_show.class);
                startActivity(i);
            }
        });




        // For Book Activity

        card_book = (ImageView) view.findViewById(R.id.book_activity);
        card_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), book_show.class);
                startActivity(i);
            }
        });



        // For Podcast Activity

        card_podcast = (ImageView) view.findViewById(R.id.podcast_activity);
        card_podcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoPodcast("https://earshot.in");
            }
        });



        // For News Activity

        card_news = (ImageView) view.findViewById(R.id.news_activity);
        card_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.ndtv.com/topic/web-apps");
            }
        });



        // For Magazine Activity

        card_magazine = (ImageView) view.findViewById(R.id.magazine_activity);
        card_magazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoMagazine("https://freemagazines.top");
            }
        });




        // For Comic Activity

        card_comic = (ImageView) view.findViewById(R.id.comic_activity);
        card_comic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), comic_show.class);
                startActivity(i);
            }
        });






        return view;
    }

    private void gotoMagazine(String s) {
        Uri maguri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, maguri));
    }

    private void gotoPodcast(String s) {
        Uri poduri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, poduri));
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
