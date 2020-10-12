package com.zk.paginglibraryexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zk.paginglibraryexample.R
import com.zk.paginglibraryexample.model.ViewEffect
import com.zk.paginglibraryexample.viewModel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
@FlowPreview
class MainActivity : AppCompatActivity() {

    private val model by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PhotoListFragment.newInstance(), PhotoListFragment::class.qualifiedName)
            .commit()

        observeViewEffect()
    }

    private fun observeViewEffect() {
        model.obtainViewEffects.observe(this, {
            trigger(it)
        })
    }

    private fun trigger(effect: ViewEffect) {
        when(effect) {
            is ViewEffect.TransitionToScreen -> {
                TODO( "implement second screen")
//                val intent = Intent(this, SinglePhotoActivity::class.java)
//                intent.putExtra(getString(R.string.extra_item), effect.article)
//                startActivity(intent)
            }
        }
    }
}
