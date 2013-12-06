package org.mifosplatform.angularui.tests.utils;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.Node;
import org.jboss.shrinkwrap.api.asset.Asset;

import java.io.InputStream;

public class ArchiveInspector {

    private final Archive<?> archive;

    public ArchiveInspector(Archive<?> archive) {
        this.archive = archive;
    }

    public InputStream open(final String path) {
        Node node = archive.get(ArchivePaths.create(path));
        Asset asset = node.getAsset();
        return asset.openStream();
    }

}
