package edu.cnm.deepdive.tabfinalclass.controller.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.tabfinalclass.R;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ContentItem> {
  private Typeface mTypeFaceLight;
  private Typeface mTypeFaceRegular;

  public MyAdapter(Context context, List<ContentItem> objects){
    super(context, 0, objects);
    mTypeFaceLight = Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf");
    mTypeFaceRegular = Typeface.createFromAsset(context.getAssets(). "OpenSans-Regular.ttf");

  }
  @SuppressLint("InflateParams")
  @NonNull
  @Override
  public View getView(int position, View convertView, @NonNull ViewGroup parent){
    ContentItem contentItem = getItem(position);
    ViewHolder holder;

    holder = new ViewHolder();
    //TODO revisit
    if (contentItem != null && contentItem.isSection) {
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_section, null);
    } else {
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
    }

    holder.tvName = convertView.findViewById(R.id.tvName);
    holder.tvDesc = convertView.findViewById(R.id.tvDesc);

    convertView.setTag(holder);

    if (contentItem != null && contentItem.isSection)
      holder.tvName.setTypeface(mTypeFaceRegular);
    else
      holder.tvName.setTypeface(mTypeFaceLight);
    holder.tvDesc.setTypeface(mTypeFaceLight);

    holder.tvName.setText(contentItem != null ? contentItem.name : null);
    holder.tvDesc.setText(contentItem != null ? contentItem.desc : null);

    return convertView;

  }


  @NonNull
  @Override
  public ContentItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.passphrase_item, parent, false);
    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ContentItem holder, int position) {
    Passphrase passphrase = passphrases.get(position);
    holder.bind(position, passphrase);
  }

  @Override
  public int getItemCount() {
    return passphrases.size();
  }
  class Holder extends RecyclerView.ViewHolder {

    private final View view;

    private Holder(@NonNull View itemView) {
      super(itemView);
      view = itemView;
    }

    private void bind(int position, Passphrase passphrase) {
      ((TextView) view).setText(passphrase.getKey());
      if (clickListener != null) {
        view.setOnClickListener((v) -> clickListener.click(v, position, passphrase));
      }
      if (contextClickListener != null) {
        view.setOnCreateContextMenuListener((menu, v, menuInfo) -> {
          contextClickListener.click(menu, position, passphrase);
        });
      }
    }

  }

  @FunctionalInterface
  public interface OnPassphraseClickListener {

    void click(View view, int position, Passphrase passphrase);

  }

  @FunctionalInterface
  public interface OnPassphraseContextClickListener {

    void click(Menu menu, int position, Passphrase passphrase);
  }

  private class ViewHolder {

    TextView tvName, tvDesc;
  }
}
