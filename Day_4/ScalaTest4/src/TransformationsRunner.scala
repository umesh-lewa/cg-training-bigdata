import com.presidio.tansformations.{CountTransformation, DropFilterTransformation, FilterTransformation, FindFilterTransformation, HeadFilterTransformation, MapTransformation, PartitionTransformation, TailFilterTransformation, TakeFilterTransformation, ZipTransformation}

object TransformationsRunner {

  def main(args:Array[String]): Unit ={

    val countries = List("Brazil","Russia", "Bahamas", "Bangladesh", "Cook Islands", "UK", "Norway", "Sweden", "Germany", "France")

    val filterTrans = new FilterTransformation()
    filterTrans.doFilter(countries,"B")

    val headFilterTrans = new HeadFilterTransformation()
    headFilterTrans.doHeadFilter(countries)

    val tailFilterTrans = new TailFilterTransformation()
    tailFilterTrans.doTailFilter(countries)

    val takeFilterTrans = new TakeFilterTransformation()
    takeFilterTrans.doTakeFilter(countries)

    val dropFilterTrans = new DropFilterTransformation()
    dropFilterTrans.doDropFilter(countries)

    val findFilterTrans = new FindFilterTransformation()
    findFilterTrans.doFindFilter(countries,"Ba")

    val mapTrans = new MapTransformation()
    mapTrans.doMap(countries)

    val countTrans = new CountTransformation()
    countTrans.doCount(countries,"B")

    val zipTrans = new ZipTransformation()
    val countries2 = List("Br", "Ru", "Ba", "Bg", "Ci", "Uk", "Ny", "Sw", "Gm", "Fr","Extra")
    zipTrans.doZipFilter(countries,countries2)

    val partitionTrans = new PartitionTransformation()
    partitionTrans.doPartitionFilter(countries,"B")

  }

}
