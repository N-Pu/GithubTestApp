package com.example.somename.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.somename.R
import com.example.somename.data.ApiManager
import com.example.somename.model.SingleUser
import com.example.somename.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SingleUserActivity : AppCompatActivity() {
    val KEY_USER_NAME = "key_user_name"
    private lateinit var mAvatarIv: ImageView
    private lateinit var mTypeTxt: TextView
    private lateinit var mNameTxt: TextView
    private lateinit var mLocationTxt: TextView
    private lateinit var mReposTxt: TextView
    private lateinit var mFollowersTxt: TextView
    private lateinit var mBioTxt: TextView
    private lateinit var mEmailTxt: TextView
    private lateinit var mFollowingTxt: TextView


    private fun initView() {
        mAvatarIv = findViewById(R.id.iv_user_avatar)
        mTypeTxt = findViewById(R.id.tv_type)
        mNameTxt = findViewById(R.id.tv_name)
        mLocationTxt = findViewById(R.id.tv_location)
        mReposTxt = findViewById(R.id.tv_repos)
        mFollowersTxt = findViewById(R.id.tv_followers)
        mBioTxt = findViewById(R.id.tv_bio)
        mEmailTxt = findViewById(R.id.tv_following)
        mFollowingTxt = findViewById(R.id.tv_email)

    }

    @SuppressLint("SetTextI18n")
    fun fillData(user: SingleUser) {

        Glide.with(this)
            .load(user.get_AvatarUrl())
            .circleCrop()
            .into(mAvatarIv)

        mTypeTxt.text = "Type : ${user.get_Type()}"
        mNameTxt.text = "Name : ${user.get_Name()}"
        mLocationTxt.text = "Location : ${user.get_Location()}"
        mReposTxt.text = "Repos : ${user.get_PublicRepos()}"
        mFollowersTxt.text = "Followers : ${user.get_Followers()}"
        mFollowingTxt.text = "Following : ${user.get_Following()}"
        mEmailTxt.text = "Email : ${user.get_Email()}"
        mBioTxt.text = user.get_Bio()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_user)

        window.statusBarColor = ContextCompat.getColor(this, R.color.dark_git)
        val userName: String? = intent.getStringExtra(KEY_USER_NAME)

        initView()
        if (userName != null) {
            loadData(userName)
        }


    }


    private fun loadData(userName: String) {

        if (NetworkUtils.isNetworkAvailable(this)) {
            val call: Call<SingleUser> = ApiManager.getApiClient().getSingleUser(userName)

            call.enqueue(object : Callback<SingleUser> {
                override fun onResponse(call: Call<SingleUser>, response: Response<SingleUser>) {
                    Log.v("TAG", "SingleUserActivity -> Success")
                    val user: SingleUser? = response.body()
                    if (user != null) {
                        fillData(user)
                    }
                }

                override fun onFailure(call: Call<SingleUser>, t: Throwable) {
                    Log.v("TAG", "SingleUserActivity -> Failure : $t")
                }

            })


        } else Log.v("TAG", "No network connection")
    }

}



