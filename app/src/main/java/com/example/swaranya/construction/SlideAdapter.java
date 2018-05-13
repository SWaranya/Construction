package com.example.swaranya.construction;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.mainmenu,
            R.drawable.choose_room,
            R.drawable.choose_date,
            R.drawable.choose_time,
            R.drawable.press_confirm
    };

    // list of titles
    public String[] lst_title = {
            "STEP 1",
            "STEP 2",
            "STEP 3",
            "STEP 4",
            "STEp 5"
    }   ;
    // list of descriptions
    public String[] lst_description = {
            "Press RESERVATION icon.",
            "Choose the meeting room that you want to reserve.",
            "Pick the date in calendar that you will coming, then press Next",
            "Choose the range of time that you want to reserve." +
                    "\n **You can use the room almost two hours.",
            "Fill purpose and member in box, then press CONFIRM "

    };

    public SlideAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slides,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slide_img);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
