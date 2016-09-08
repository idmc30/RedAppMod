package proyecto.contol.idmc.appred.redapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class principalPaciente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_paciente);

        Toolbar toolbar= (Toolbar) findViewById(R.id.tollbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabLayout tabLayout=(TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);



    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new fragmentNPaciente();
                case 1:
                    return new fragmentLPaciente();
                case 2:
                    return new fragmentVPaciente();
                default:
                    return new fragmentVPaciente();
            }

        }


        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public  CharSequence getPageTitle(int position){

            switch (position){
                case 0:
                    return "Registra Paciente";
                case 1:
                    return "Listado Paciente";
                case 2:
                    return "Visitas Domiciliarias";
                default:
                    return "Pediente PAciente";

            }

        }
    }

}
