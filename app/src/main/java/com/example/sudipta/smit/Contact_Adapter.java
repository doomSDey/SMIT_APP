package com.example.sudipta.smit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class Contact_Adapter extends RecyclerView.Adapter<Contact_Adapter.contactAdapterViewHolder>{

    private Context mCtx;
    private List<contact_det> contact_dets;

    public Contact_Adapter(Context mCtx, List<contact_det> contact_dets) {
        this.mCtx = mCtx;
        this.contact_dets = contact_dets;
    }

    @NonNull
    @Override
    public contactAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mCtx);
        View view=layoutInflater.inflate(R.layout.contact_layout,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new contactAdapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull contactAdapterViewHolder holder, int position) {
        contact_det contact =contact_dets.get(position);
        holder.textViewName.setText(contact.getEmp_name() );
        // holder.textViewCode.setText(attendence.getCode() );
        holder.textViewDesignation.setText(contact.getDesignation()+"("+contact.getDept()+")" );
    }

    @Override
    public int getItemCount() {
        return contact_dets.size();
    }

    class contactAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName,textViewDesignation;
        Button call,share,email;
        public contactAdapterViewHolder(View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.textView5);
            //textViewCode=itemView.findViewById(R.id.textView2);
            textViewDesignation=itemView.findViewById(R.id.textView6);
            call=itemView.findViewById(R.id.call);
            share=itemView.findViewById(R.id.share);
            email=itemView.findViewById(R.id.email);
        }
    }
}
