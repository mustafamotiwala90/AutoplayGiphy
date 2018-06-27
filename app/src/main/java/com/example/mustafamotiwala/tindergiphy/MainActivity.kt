package com.example.mustafamotiwala.tindergiphy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import com.example.mustafamotiwala.tindergiphy.Adapter.RecyclerTouchListener
import com.example.mustafamotiwala.tindergiphy.Adapter.TinderGifAdapter
import com.example.mustafamotiwala.tindergiphy.Model.Original
import com.example.mustafamotiwala.tindergiphy.Model.TinderGif
import com.example.mustafamotiwala.tindergiphy.Presenter.ImageGridPresenter
import com.example.mustafamotiwala.tindergiphy.UI.GiphyFeedView
import com.example.mustafamotiwala.tindergiphy.Utils.ScaleItemDecorator
import kotlinx.android.synthetic.main.activity_main.*
import com.example.mustafamotiwala.tindergiphy.Utils.MarginItemDecorator
import com.example.mustafamotiwala.tindergiphy.Utils.StringUtils.*


class MainActivity : AppCompatActivity(), GiphyFeedView {

    lateinit var presenter: ImageGridPresenter<GiphyFeedView>
    lateinit var adapter: TinderGifAdapter
    val COLUMN_COUNT = 2
    lateinit var itemsList: List<TinderGif>
    lateinit var gridLayoutManager:StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        createPresenter()
    }


    private fun createPresenter() {
        presenter = ImageGridPresenter()
        presenter.onAttach(this)
        presenter.showContent()
    }


    private fun initRecyclerView() {
        image_rv.isClickable = true
        image_rv.setHasFixedSize(true)
        gridLayoutManager = StaggeredGridLayoutManager(COLUMN_COUNT,
                StaggeredGridLayoutManager.VERTICAL)
        image_rv.itemAnimator = ScaleItemDecorator(AccelerateDecelerateInterpolator())
        val marginItemDecorator = MarginItemDecorator(
                resources.getDimensionPixelOffset(R.dimen.item_margin), COLUMN_COUNT)
        image_rv.addItemDecoration(marginItemDecorator)
        image_rv.layoutManager = gridLayoutManager
        image_rv.addOnItemTouchListener(RecyclerTouchListener(this,
                image_rv, object : RecyclerTouchListener.ClickListener {
            override fun onClick(view: View, position: Int) {
                val model: TinderGif = itemsList.get(position)
                val original: Original = model.images.original
                val intent = Intent(this@MainActivity, GifDetailActivity::class.java)
                intent.putExtra(EXTRA_ORIGINAL_MODEL, original)
                intent.putExtra(EXTRA_USER, model.user)
                startActivity(intent)
            }

            override fun onLongClick(view: View, position: Int) {
                // TODO : Override onLong click ?
            }
        }))
        attachOnScroll()
    }

    fun attachOnScroll() {
        image_rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {

//                var position = gridLayoutManager.las
            }
        })
    }

    fun loadNextDataFromApi(offset: Int) {
        presenter.loadMore(offset)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showContent(items: MutableList<TinderGif>?) {
        itemsList = items!!
        adapter = TinderGifAdapter(itemsList, this)
        image_rv.adapter = adapter
    }

    override fun appendContent(nextPageItems: MutableList<TinderGif>?) {
        if (nextPageItems != null) {
            adapter.appendItems(nextPageItems)
        }

    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
