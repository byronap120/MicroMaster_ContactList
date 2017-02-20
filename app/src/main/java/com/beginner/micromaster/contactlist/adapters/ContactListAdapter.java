package com.beginner.micromaster.contactlist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.beginner.micromaster.contactlist.R;
import com.beginner.micromaster.contactlist.models.Contact;

import java.util.ArrayList;

/**
 * Created by Byron on 2/19/2017.
 */

public class ContactListAdapter extends ArrayAdapter<Contact> {

    public ContactListAdapter(Context context, ArrayList<Contact> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
        }
        //get reference to object on list
        Contact contact = getItem(position);

        TextView contactName = (TextView) convertView.findViewById(R.id.contact_name);
        TextView contactLastName = (TextView) convertView.findViewById(R.id.contact_last_name);
        TextView contactEmail = (TextView) convertView.findViewById(R.id.textViewEmail);
        TextView contactPhoneNumber = (TextView) convertView.findViewById(R.id.textViewPhoneNumber);

        contactName.setText(contact.getName());
        contactLastName.setText(contact.getLastName());
        contactEmail.setText(contact.getEmail());
        contactPhoneNumber.setText(contact.getPhoneNumber() + "");

        return convertView;
    }
}