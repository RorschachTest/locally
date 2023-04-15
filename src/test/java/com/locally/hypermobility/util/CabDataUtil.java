package com.locally.hypermobility.util;

import org.springframework.data.geo.Point;

import java.util.List;

public class CabDataUtil {

    public static final List<Point> cabLocation = List.of(
            new Point(17.458180, 78.372318),//office
            new Point(17.449037, 78.378850),//trident
            new Point(17.434855, 78.341058)//isb road
    );

    public static final Point rider = new Point(new Point(17.461395, 78.356649));


}
