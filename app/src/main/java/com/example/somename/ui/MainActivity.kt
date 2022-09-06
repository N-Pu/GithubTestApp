package com.example.somename.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.somename.R
import com.example.somename.adapters.CustomScrollListener
import com.example.somename.adapters.UsersRecyclerAdapter
import com.example.somename.data.ApiManager
import com.example.somename.model.ListUser
import com.example.somename.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), UsersRecyclerAdapter.OnRvItemClickListener {
    private val LIMIT = 10
    private lateinit var mRecyclerAdapter: UsersRecyclerAdapter
    private lateinit var mUsers: ArrayList<ListUser>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = ContextCompat.getColor(this, R.color.dark_git)

        mUsers = ArrayList()
        initRecyclerView()
        loadDataFromApi(0)

    }


    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_github_users)
        val layoutManager = LinearLayoutManager(this)
        val scrollListener = object : CustomScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemCount: Int, view: RecyclerView) {
                loadDataFromApi(totalItemCount)
            }
        }
        recyclerView.layoutManager = layoutManager
        recyclerView.addOnScrollListener(scrollListener)
        mRecyclerAdapter = UsersRecyclerAdapter(mUsers, this)
        recyclerView.adapter = mRecyclerAdapter

    }

    private fun loadDataFromApi(page: Int)  {
        if (NetworkUtils.isNetworkAvailable(this)) {



            val call: Call<List<ListUser>> = ApiManager.getApiClient().getUsers(page, LIMIT)


            call.enqueue(object : Callback<List<ListUser>> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<List<ListUser>>,
                    response: Response<List<ListUser>>
                ) {

                    Log.v("TAG", "MainActivity -> Success")
                    val users: List<ListUser>? = response.body()
                    if (users != null) {
                        mUsers.addAll(users)
                        mRecyclerAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<List<ListUser>>, t: Throwable) {
                    toastFail()
                    Log.v("TAG", "MainActivity -> Failure : $t")

                }

            })

        } else
            Log.v("TAG", "No network connection")
    }



    private fun toastFail() {
        Toast.makeText(this@MainActivity, "Connection Error", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(pos: Int) {
        val intent = Intent(this, SingleUserActivity::class.java)
        intent.putExtra(SingleUserActivity().KEY_USER_NAME, mUsers[pos].getLogin())
        startActivity(intent)
    }


}
