package com.example.sudipta.smit;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ContactDeptAdapter  extends RecyclerView.Adapter<ContactDeptAdapter.ContactDeptViewHolder>{

    private Context mCtx;
    private List<String>contactDeptLists;
    public ContactDeptAdapter(Context mCtx, List<String> contactDeptLists) {
        this.mCtx = mCtx;
        this.contactDeptLists=contactDeptLists;

    }



    @NonNull
    @Override
    public ContactDeptAdapter.ContactDeptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mCtx);
        View view=layoutInflater.inflate(R.layout.dept_layout,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        return new ContactDeptViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final ContactDeptViewHolder holder, int position) {
        String contactDeptList=contactDeptLists.get(position);
        // if(marks_det.getCode()!=null && marks_det.getSubject()!=null)
        holder.button.setText(contactDeptList);
        //holder.progressBar.setProgress((int) attendence.getPer());
        //double x=attendence.getPer();
        //int y=(int)x;
        //String s=String.valueOf(y);
        //holder.textViewper.setText(s+"%");
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = holder.button.getText().toString();
                //String author = authorTextView.getText().toString();    //two text views defined on top of the viewHolder

                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                //bundle.putString("author", author);

                Contact_Search contact_search = new Contact_Search();
                contact_search.setArguments(bundle);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,contact_search).addToBackStack("contact_search").commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactDeptLists.size();
    }


    public class ContactDeptViewHolder extends RecyclerView.ViewHolder {
        Button button;
        LinearLayout linearLayout;
        public ContactDeptViewHolder(View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.button6);
            linearLayout=itemView.findViewById(R.id.linear);
            //textViewCode=itemView.findViewById(R.id.textView2);

    }
}
}
