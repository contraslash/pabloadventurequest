package com.contraslash.android.pabloadventurequest.applications.game.models;

import android.content.Context;

import com.contraslash.android.db.BaseDAO;
import com.contraslash.android.db.Table;

/**
 * Created by ma0 on 3/20/16.
 */
public class QuestionDAO extends BaseDAO {

    public QuestionDAO(Context context) {
        super(context);
    }

    @Override
    protected String getTableName() {
        return new Question().getTableName();
    }

    @Override
    protected Object getSelf() {
        return this;
    }

    @Override
    protected Table getPrototype() {
        return new Question();
    }
}
