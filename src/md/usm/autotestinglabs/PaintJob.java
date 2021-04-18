package md.usm.autotestinglabs;

public class PaintJob {
    public static void main(String[] args) {

        int buckets = getBucketCount(3.65, 2.16, 1.4, 1);
        System.out.println("1 method, buckets: " + buckets);

        buckets = getBucketCount(7.25, 5.4, 2.35);
        System.out.println("2 method, buckets: " + buckets);

        buckets = getBucketCount(2.38, 1.75);
        System.out.println("3 method, buckets: " + buckets);
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }
        return (int) Math.ceil((width * height) / areaPerBucket) - extraBuckets;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;
        }
        return (int) Math.ceil((width * height) / areaPerBucket);
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }
        return (int) Math.ceil(area / areaPerBucket);
    }

}