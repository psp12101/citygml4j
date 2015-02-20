citygml4j
=========

citygml4j is a Java class library and API for facilitating work with the [OGC City Geography Markup Language (CityGML)](http://www.opengeospatial.org/standards/citygml). citygml4j makes it easy to read, process, and write CityGML datasets, and to develop CityGML-aware software applications.

License
-------
citygml4j is free software under the [GNU LGPL Version 3.0](http://www.gnu.org/licenses/lgpl.html). See the `LICENSE.txt` file for more details.

Contributing
------------
* To file bugs found in the software create a GitHub issue.
* To contribute code for fixing filed issues create a pull request with the issue id.
* To propose a new feature create a GitHub issue and open a discussion.

Building
--------
citygml4j depends on JRE 7 or higher. The project uses [Apache Ant](http://ant.apache.org/) as the build tool. To build the library, run the `build.xml` file from the root of the repository with `dist` as target. 

    % ant dist

This will create a folder `citygml4j-<version>` with the following subfolders:
* `javadoc` -- the Javadoc documentation
* `lib` -- the citygml4j library and its mandatory dependencies
* `license` -- license information
* `samples` -- a collection of citygml4j sample programs

Simply put the `citygml4j-<version>.jar` library file and its mandatory dependencies from the `lib` folder on your classpath to start developing with citygml4j. Have fun :-)

Maven artifact
--------------
citygml4j is also available as [Maven](http://maven.apache.org/) artifact from the [Central Maven Repository](http://search.maven.org/). To add citygml4j  to your project with Maven, add the following code to your `pom.xml`:

```xml
<dependency>
  <groupId>org.citygml4j</groupId>
  <artifactId>citygml4j</artifactId>
  <version>2.2</version>
</dependency>
```

Sample programs
---------------
citygml4j provides a number of sample programs that demonstrate the use of the library. Build the library from source with [Apache Ant](http://ant.apache.org/) as described above. This will deploy the sample programs in the `citygml4j-<version>/samples` folder.

The sample programs are organized into subfolders, each addressing a different use case of citygml4j. Ant `build.xml` files are provided to easily run the sample programs. Note that the `build.xml` files may contain more than just the default target.

More information
----------------
[OGC CityGML](http://www.opengeospatial.org/standards/citygml) is an open data model and XML-based format for the storage and exchange of semantic 3D city models. It is an application schema for the [Geography Markup Language version 3.1.1 (GML3)](http://www.opengeospatial.org/standards/gml), the extendible international standard for spatial data exchange issued by the Open Geospatial Consortium (OGC) and the ISO TC211. The aim of the development of CityGML is to reach a common definition of the basic entities, attributes, and relations of a 3D city model.

CityGML is an international OGC standard and can be used free of charge.