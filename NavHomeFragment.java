package com.example.dell.spotsoontest;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavHomeFragment extends Fragment {


    private FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<CoverFlowList> mData = new ArrayList<>(0);
    private TextSwitcher mTitle;

    public NavHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_nav_home, container, false);

        final TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tablayout);
        final ViewPager viewPager = (ViewPager)view.findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getFragmentManager());

        tabPagerAdapter.addfragment(new VideosFragment());
        tabPagerAdapter.addfragment(new ImagesFragment());
        tabPagerAdapter.addfragment(new MileStoneFragment());

        viewPager.setAdapter(tabPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.video).setText("Videos");
        tabLayout.getTabAt(1).setIcon(R.drawable.images).setText("Images");
        tabLayout.getTabAt(2).setIcon(R.drawable.milestone).setText("MileStone");
        tabLayout.getTabAt(0).select();

        mData.add(new CoverFlowList(R.drawable.img1, R.string.title1));
        mData.add(new CoverFlowList(R.drawable.img2, R.string.title1));
        mData.add(new CoverFlowList(R.drawable.img3, R.string.title1));
        mData.add(new CoverFlowList(R.drawable.img4, R.string.title1));

        mTitle = (TextSwitcher)view.findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                TextView textView = (TextView) inflater.inflate(R.layout.item_coverflow_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        mAdapter = new CoverFlowAdapter(getContext());
        mAdapter.setData(mData);
        mCoverFlow = (FeatureCoverFlow)view.findViewById(R.id.coverflow);
        mCoverFlow.setAdapter(mAdapter);

        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),
                        getResources().getString(mData.get(position).titleResId),
                        Toast.LENGTH_SHORT).show();
            }
        });

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(getResources().getString(mData.get(position).titleResId));
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
            }
        });

        return view;
    }

}
