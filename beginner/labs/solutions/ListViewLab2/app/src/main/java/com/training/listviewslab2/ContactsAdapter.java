package com.training.listviewslab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactsAdapter extends BaseAdapter {
    ArrayList<Contact> contacts;
    LayoutInflater layoutInflater;

    public ContactsAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.contacts = new ArrayList<>();

    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder = null;

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.row, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.mobile = (TextView) view.findViewById(R.id.mobile);

            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        Contact contact = (Contact) getItem(position);
        viewHolder.name.setText(contact.name);
        viewHolder.mobile.setText(contact.mobile);
        return view;

    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        notifyDataSetChanged();;

    }

    public void deleteContact(int position) {
        contacts.remove(position);
        notifyDataSetChanged();;

    }

    static class ViewHolder {
        TextView name;
        TextView mobile;
    }

}
