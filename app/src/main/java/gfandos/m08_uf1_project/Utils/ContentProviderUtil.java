package gfandos.m08_uf1_project.Utils;

/**
 * Created by Gerard on 08/01/2017.
 */

import gfandos.m08_uf1_project.BuildConfig;
import gfandos.m08_uf1_project.Pojos.Book;
import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class ContentProviderUtil extends CupboardContentProvider {

    public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";

    static {
        cupboard().register(Book.class);
    }

    public ContentProviderUtil() {
        super(AUTHORITY, 1);
    }

}
