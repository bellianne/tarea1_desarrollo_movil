package com.xcheko51x.navigationdraweractivity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInicio extends Fragment {

    AppBarLayout appBar;
    TabLayout tabLayout;
    ViewPager vpPaginas;

    public FragmentInicio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_fragment_inicio, container, false);

        View contenedor = (View) container.getParent();

        appBar = container.findViewById(R.id.appBar);
        tabLayout = new TabLayout(getActivity());
        tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));

        appBar.addView(tabLayout);

        vpPaginas = vista.findViewById(R.id.vpPaginas);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
        vpPaginas.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(vpPaginas);

        return vista;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(tabLayout);
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        String[] paginasTitulos = {"NUEVO", "ENTRADAS", "ESTADÍSTICAS"};

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new FragmentTabNuevo();
                case 1:
                    return new FragmentTabEntradas();
                case 2:
                    return new FragmentTabEstadisticas();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return paginasTitulos[position];
        }
    }
}
