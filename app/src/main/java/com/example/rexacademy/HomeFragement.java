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


public class HomeFragement extends Fragment {

    ImageView gotoCategory;
    ImageView coursera, edx, udemy, greatLearning;
    ImageView googleSearchBar;
    ImageView pdfMaker;
    ImageView googleTranslate;
    ImageView html, css, Javascript, React;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //For Going to Fragment Activity
        gotoCategory = (ImageView) view.findViewById(R.id.gotoCategory);
        gotoCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), book_show.class);
                startActivity(intent);
            }
        });

        //Learning Platform
        coursera = (ImageView) view.findViewById(R.id.gotoCoursera);
        edx = (ImageView) view.findViewById(R.id.gotoEdx);
        udemy = (ImageView) view.findViewById(R.id.gotoUdemy);
        greatLearning = (ImageView) view.findViewById(R.id.gotoGreatLearning);


        //For Going to Coursera
        coursera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseraUrl("https://www.coursera.org/");
            }
        });

        edx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edxUrl("https://www.edx.org");
            }
        });

        udemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                udemyUrl("https://www.udemy.com");
            }
        });

        greatLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glUrl("https://www.greatlearning.com");
            }
        });


        //For Google Search Bar

        googleSearchBar = (ImageView) view.findViewById(R.id.googleSearchBar);
        googleSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleBar("https://www.google.com/");
            }
        });


        //For Going to the Pdf Maker Activity
        pdfMaker = (ImageView) view.findViewById(R.id.pdfmaker);
        pdfMaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdfUrl("https://smallpdf.com");
            }
        });


        //For Going to Google Translator App
        googleTranslate = (ImageView) view.findViewById(R.id.googleTranslator);
        googleTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gTranslateUrl("https://translate.google.co.in");
            }
        });


        //For Web Development
        html = (ImageView) view.findViewById(R.id.gotoHtml);
        css = (ImageView) view.findViewById(R.id.gotoCss);
        Javascript = (ImageView) view.findViewById(R.id.gotoJavaScript);
        React = (ImageView) view.findViewById(R.id.gotoReact);

        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                htmlUrl("https://www.codecademy.com/learn/learn-html");
            }
        });


        css.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cssUrl("https://www.codecademy.com/learn/learn-css");

            }
        });

        Javascript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jsUrl("https://www.codecademy.com/learn/introduction-to-javascript");
            }
        });

        React.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reactUrl("https://www.codecademy.com/learn/react-101");

            }
        });



//----------------------------------------------------------------------------------------------------------------------------------------------------


                return view;


    }

    private void reactUrl(String s) {
        Uri reacturi = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, reacturi));
    }

    private void jsUrl(String s) {
        Uri jsuri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, jsuri));
    }

    private void cssUrl(String s) {
        Uri cssuri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, cssuri));
    }

    private void htmlUrl(String s) {
        Uri htmluri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, htmluri));
    }

    private void gTranslateUrl(String s) {
        Uri gturi = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, gturi));
    }

    private void pdfUrl(String s) {
        Uri pdfuri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, pdfuri));
    }

    private void googleBar(String s) {
        Uri googleuri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, googleuri));
    }

    private void glUrl(String s) {
        Uri gluri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, gluri));
    }

    private void udemyUrl(String s) {
        Uri udemyuri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, udemyuri));
    }

    private void edxUrl(String s) {
        Uri edxuri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, edxuri));
    }

    private void courseraUrl(String s) {
        Uri courseuri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, courseuri));
    }


}
