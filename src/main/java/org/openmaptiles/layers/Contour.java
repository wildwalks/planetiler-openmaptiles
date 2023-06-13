package org.openmaptiles.layers;
import static org.openmaptiles.util.Utils.nullIfEmpty;

import com.carrotsearch.hppc.LongObjectHashMap;
import com.google.common.util.concurrent.AtomicDouble;
import com.onthegomap.planetiler.FeatureCollector;
import com.onthegomap.planetiler.FeatureMerge;
import com.onthegomap.planetiler.VectorTile;
import com.onthegomap.planetiler.collection.Hppc;
import com.onthegomap.planetiler.config.PlanetilerConfig;
import com.onthegomap.planetiler.geo.GeometryException;
import com.onthegomap.planetiler.reader.SourceFeature;
import com.onthegomap.planetiler.reader.osm.OsmElement;
import com.onthegomap.planetiler.reader.osm.OsmReader;
import com.onthegomap.planetiler.reader.osm.OsmRelationInfo;
import com.onthegomap.planetiler.stats.Stats;
import com.onthegomap.planetiler.util.Translations;
import com.onthegomap.planetiler.util.ZoomFunction;
import java.util.List;
import java.util.Map;
import org.openmaptiles.OpenMapTilesProfile;
import org.openmaptiles.generated.OpenMapTilesSchema;
import org.openmaptiles.generated.Tables;
import org.openmaptiles.generated.OpenMapTilesSchema.AerodromeLabel.Fields;
import org.openmaptiles.util.OmtLanguageUtils;
import org.openmaptiles.util.Utils;
import org.openmaptiles.Layer;


public class Contour implements Layer, OpenMapTilesProfile.FeaturePostProcessor, OpenMapTilesProfile.ContourLinesProcessor {

  private static final String LAYER_NAME = "contour";

  public Contour(Translations translations, PlanetilerConfig config, Stats stats) {}

  @Override
  public String name() {
    return LAYER_NAME;
  }

  @Override
  public void processContourLines(SourceFeature feature, FeatureCollector features) {
      features.line(LAYER_NAME)
          .setBufferPixels(4)
          .setMinZoom(14)
          .setAttr(Fields.CLASS, feature.getString("name"));
  }
}