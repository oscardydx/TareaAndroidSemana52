package com.example.vulcanussoft.carviewfinal;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.vulcanussoft.carviewfinal.adapter.PageAdapter;
import com.example.vulcanussoft.carviewfinal.fragment.PerfilFragment;
import com.example.vulcanussoft.carviewfinal.fragment.RecyclerViewFragment;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    public Toolbar toolbar;
    private ViewPager viewPager;

    //Toolbar actionbare=(Toolbar) findViewById(R.id.Bar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout= findViewById(R.id.tabs);
        toolbar= findViewById(R.id.toolbar);
        viewPager= findViewById(R.id.viewPager);

        setUpViewPager();



      if (toolbar != null){
          setSupportActionBar(toolbar);
      }

       // Fab();
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }
    private void setUpViewPager(){

    viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
    tabLayout.setupWithViewPager(viewPager);
    tabLayout.getTabAt(0).setIcon(R.drawable.ic_doghouse);
    tabLayout.getTabAt(1).setIcon(R.drawable.ic_dogperfil);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.About:
                Intent intent=new Intent(MainActivity.this,Sobre_Nosotros.class);
                startActivity(intent);
                break;
            case R.id.Contact:
                Intent intent2=new Intent(MainActivity.this,FormularioContacto.class);
                startActivity(intent2);
                break;
            case R.id.mRefresh:
               Intent intent3=new Intent(MainActivity.this,LikeActivity.class);
               startActivity(intent3);

                break;
        }
        return super.onOptionsItemSelected(item);
    }


 /*  private void Fab() {
        FloatingActionButton miFab= findViewById(R.id.floatButton);
        miFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getBaseContext(),getString(R.string.app_name), Toast.LENGTH_SHORT).show();
                Snackbar.make(view,getResources().getString(R.string.app_name),Snackbar.LENGTH_SHORT)
                                .setAction(getResources().getString(R.string.mensaje), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SnackBAR","Click en SnackBar");
                            }
                        }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();

                Intent intent= new Intent(MainActivity.this,LikeActivity.class);
                startActivity(intent);

            }
        }


        );
    }*/
}




