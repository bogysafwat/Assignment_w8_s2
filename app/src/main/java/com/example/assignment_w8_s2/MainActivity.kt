package com.example.assignment_w8_s2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import com.example.assignment_w8_s2.databinding.ActivityMainBinding
import com.example.assignment_w8_s2.ui.theme.Assignment_w8_s2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main)

        val book= mutableListOf<Books>(
            Books("Blood Line","by Jemes Rollins",R.drawable.blood,2.5f),
            Books("The Sord Thief","by Peter Lerangis",R.drawable.sword,2.0f),
            Books("Terra Nostara","by Carlos Fuentes",R.drawable.nostra,3.5f),
            Books("Angels & Demons","by Dan Brown",R.drawable.angels,4.0f),
            Books("The HummingBirds's\n Daughter","by luis Alberto Urrea",R.drawable.humming,3.5f),
            Books("One Hundred Years\n Solitude","by Grabiel Garcia Marquez",R.drawable.solitude,3.5f),
            Books("The House Of The Spirits","by Isabel Allende",R.drawable.spirits,4.0f),

        )

        val booksAdapter=BookAdapter(book)
        binding.rvBooks.adapter=booksAdapter


        binding.toolbar.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

     binding.toolbar.materialToolbar.setOnMenuItemClickListener{
         Toast.makeText(this, R.string.notifcation_clicked, Toast.LENGTH_SHORT).show()
         true
     }

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.reviews->{
                    Toast.makeText(this,R.string.review_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.favorite->{
                    Toast.makeText(this,R.string.favorite_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.search->{
                    Toast.makeText(this,R.string.search_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.profile->{
                    Toast.makeText(this,R.string.profile_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.settings->{
                    Toast.makeText(this,R.string.settings_clicked,Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                else ->false

            }
        }
    }
}