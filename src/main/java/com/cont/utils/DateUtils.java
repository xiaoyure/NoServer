package com.cont.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {


	public final static String[] CN_WEEKS = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

	/**
	 * 获得当前日期时间
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 */
	public static String currentDatetime() {
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return datetimeFormat.format(new Date());
	}

	/**
	 * 格式化日期时间
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 */
	public static String formatDatetime(Date date) {
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return datetimeFormat.format(date);
	}

	/**
	 * 格式化日期时间
	 *
	 * @param date
	 * @param pattern
	 *            格式化模式，详见{@link SimpleDateFormat}构造器
	 *            <code>SimpleDateFormat(String pattern)</code>
	 * @return
	 */
	public static String formatDatetime(Date date, String pattern) {
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat customFormat = (SimpleDateFormat) datetimeFormat.clone();
		customFormat.applyPattern(pattern);
		return customFormat.format(date);
	}

	/**
	 * 格式化日期
	 * <p>
	 * 日期格式yyyy-MM-dd
	 *
	 * @return
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * 获得当前时间
	 * <p>
	 * 时间格式HH:mm:ss
	 *
	 * @return
	 */
	public static String currentTime() {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		return timeFormat.format(new Date());
	}

	/**
	 * 格式化时间
	 * <p>
	 * 时间格式HH:mm:ss
	 *
	 * @return
	 */
	public static String formatTime(Date date) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		return timeFormat.format(date);
	}

	/**
	 * 获得当前时间的<code>java.util.Date</code>对象
	 *
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	public static Calendar calendar() {
		Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		return cal;
	}

	/**
	 * 获得当前时间的毫秒数
	 * <p>
	 * 详见{@link System#currentTimeMillis()}
	 *
	 * @return
	 */
	public static long millis() {
		return System.currentTimeMillis();
	}

	/**
	 *
	 * 获得当前Chinese月份
	 *
	 * @return
	 */
	public static int month() {
		return calendar().get(Calendar.MONTH) + 1;
	}

	/**
	 * 获得月份中的第几天
	 *
	 * @return
	 */
	public static int dayOfMonth() {
		return calendar().get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 今天是星期的第几天
	 *
	 * @return
	 */
	public static int dayOfWeek() {
		return calendar().get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 今天是年中的第几天
	 *
	 * @return
	 */
	public static int dayOfYear() {
		return calendar().get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 判断原日期是否在目标日期之前（参数类型为Date）
	 *
	 * @param src
	 * @param dst
	 * @return
	 */
	public static boolean isBefore(Date src, Date dst) {
		return src.before(dst);
	}

	/**
	 *判断原日期是否在目标日期之前（参数类型为String时间戳）
	 * @param this_ts
	 * @param goal_ts
	 * @return
	 * @throws ParseException
	 */
	public static boolean thisTimeAfterGoal(String this_ts,String goal_ts) throws ParseException{
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		c.setTime(sdf.parse(goal_ts));
		long goal_tsMillis = c.getTimeInMillis();
		Date goal_date = new Date(goal_tsMillis);

		c.setTime(sdf.parse(this_ts));
		long this_tsMillis = c.getTimeInMillis();
		Date this_date = new Date(this_tsMillis);
		boolean result = DateUtils.isAfter(this_date, goal_date);
		return result;
	}

	/**
	 * 判断原日期(日期格式为Date)是否在目标日期之后
	 *
	 * @param src
	 * @param dst
	 * @return
	 */
	public static boolean isAfter(Date src, Date dst) {
		return src.after(dst);
	}

	/**
	 * 判断两日期是否相同
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isEqual(Date date1, Date date2) {
		return date1.compareTo(date2) == 0;
	}

	/**
	 * 判断某个日期是否在某个日期范围
	 *
	 * @param beginDate
	 *            日期范围开始
	 * @param endDate
	 *            日期范围结束
	 * @param src
	 *            需要判断的日期
	 * @return
	 */
	public static boolean between(Date beginDate, Date endDate, Date src) {
		return beginDate.before(src) && endDate.after(src);
	}

	/**
	 * 获得当前月的最后一天
	 * <p>
	 * HH:mm:ss为0，毫秒为999
	 *
	 * @return
	 */
	public static Date lastDayOfMonth() {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_MONTH, 0); // M月置零
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);// 月份+1
		cal.set(Calendar.MILLISECOND, -1);// 毫秒-1
		return cal.getTime();
	}

	/**
	 * 获得当前月的第一天
	 * <p>
	 * HH:mm:ss SS为零
	 *
	 * @return
	 */
	public static Date firstDayOfMonth() {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		return cal.getTime();
	}

	private static Date weekDay(int week) {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_WEEK, week);
		return cal.getTime();
	}

	/**
	 * 获得周五日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 *
	 * @return
	 */
	public static Date friday() {
		return weekDay(Calendar.FRIDAY);
	}

	/**
	 * 获得周六日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 *
	 * @return
	 */
	public static Date saturday() {
		return weekDay(Calendar.SATURDAY);
	}

	/**
	 * 获得周日日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 *
	 * @return
	 */
	public static Date sunday() {
		return weekDay(Calendar.SUNDAY);
	}

	/**
	 * 将字符串日期时间转换成java.util.Date类型
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 *
	 * @param datetime
	 * @return
	 */
	public static Date parseDatetime(String datetime) throws ParseException {
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return datetimeFormat.parse(datetime);
	}

	/**
	 * 将字符串日期转换成java.util.Date类型
	 * <p>
	 * 日期时间格式yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.parse(date);
	}

	/**
	 * 将字符串日期转换成java.util.Date类型
	 * <p>
	 * 时间格式 HH:mm:ss
	 *
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date parseTime(String time) throws ParseException {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		return timeFormat.parse(time);
	}

	/**
	 * 根据自定义pattern将字符串日期转换成java.util.Date类型
	 *
	 * @param datetime
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDatetime(String datetime, String pattern) throws ParseException {
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = (SimpleDateFormat) datetimeFormat.clone();
		format.applyPattern(pattern);
		return format.parse(datetime);
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate,Date bdate) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 *字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate,String bdate) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 将字符串的时间转换成秒long类型
	 * HH:mm:ss ---> long
	 */
	public static long strToTime(String time){

		long hour = Long.parseLong(time.substring(0,2)) * 60 * 60;
		long minute = Long.parseLong(time.substring(3,5)) * 60;
		long second = Long.parseLong(time.substring(6,8));

		return hour+minute+second;
	}

	/**
	 * 将字符串的时间转换成毫秒long类型
	 * HH:mm:ss ---> long
	 */
	public static long strToTimeMi(String time){
		long hour = Long.parseLong(time.substring(0,2)) * 60 * 60;
		long minute = Long.parseLong(time.substring(3,5)) * 60;
		long second = Long.parseLong(time.substring(6,8));

		return (hour+minute+second)*1000;
	}

	/**
	 * 将long类型转换成字符串类型的时间
	 */
	public static String timeToStr(long millis){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date(millis);
		String str=sdf.format(date);
		return str;
	}

	/**
	 * 已知开始时间（时间戳）和时长（单位：分钟），求结束时间
	 * @param start_ts
	 * @param active_time
	 * @return
	 * @throws ParseException
	 */
	public static String startTimeAddActiveTimeToEndTime(String start_ts,String active_time) throws ParseException{

		int activeTime = Integer.parseInt(active_time);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		c.setTime(sdf.parse(start_ts));
		long start_tsMillis = c.getTimeInMillis();
		long activeTimeMillis = (long)activeTime*60*1000;
		long end_tsMillis = start_tsMillis+activeTimeMillis;
		Date end_date = new Date(end_tsMillis);
		String end_ts = sdf.format(end_date);
		return end_ts;
	}

	/**
	 * 已知结束时间（时间戳）和时长（单位：分钟），求开始时间
	 * @author 许燊燊
	 * @param end_ts
	 * @param active_time
	 * @return
	 * @throws ParseException
	 */
	public static String endTimeAddActiveTimeToStartTime(String end_ts,String active_time) throws ParseException{

		int activeTime = Integer.parseInt(active_time);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		c.setTime(sdf.parse(end_ts));
		long end_tsMillis = c.getTimeInMillis();
		long activeTimeMillis = (long)activeTime*60*1000;
		long start_tsMillis = end_tsMillis-activeTimeMillis;
		Date start_date = new Date(start_tsMillis);
		String start_ts = sdf.format(start_date);
		return start_ts;
	}

	/**
	 * 计算两个时间之间的差值 单位：分钟
	 *
	 * @param start_ts
	 * @param end_ts
	 * @return
	 * @throws ParseException
	 */
	public static String startTimeGoEndTimeToMinute(String start_ts,String end_ts) throws ParseException{

		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		c.setTime(sdf.parse(start_ts));
		c2.setTime(sdf.parse(end_ts));
		long start_tsMillis = c.getTimeInMillis();
		long end_tsMillis = c2.getTimeInMillis();
		long minuteMillis = end_tsMillis - start_tsMillis;
		long minuteCount = minuteMillis/60/100;
		return String.valueOf(minuteCount);
	}

	/**
	 * 计算两个时间之间的差值 单位：秒
	 *
	 * @param start_ts
	 * @param end_ts
	 * @return
	 * @throws ParseException
	 */
	public static Integer startTimeGoEndTimeToSec(String start_ts,String end_ts) throws ParseException{

		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		c.setTime(sdf.parse(start_ts));
		c2.setTime(sdf.parse(end_ts));
		long start_tsMillis = c.getTimeInMillis();
		long end_tsMillis = c2.getTimeInMillis();
		long minuteMillis = end_tsMillis - start_tsMillis;
		long secCount = minuteMillis/1000;
		return Integer.valueOf((int) secCount);
	}

	/**
	 * 输出今年的二月份有多少天
	 * @param year
	 * @return
	 */
	public static int thisYearFebHasDays(Integer year){
		String string;
		int month_day;

		if((

				((year%4==0)&&(year%100!=0))||(year%400==0))
				&&
				((year%3200!=0)||(year%172800==0))

				){
			//string="是闰年！";
			month_day=29;
		}else{
			//string="不是闰年！";
			month_day=28;
		}
		return month_day;
	}

	public static boolean judgeTSIfLegal(String time){
		int year = Integer.parseInt(time.substring(0,4));
		int month = Integer.parseInt(time.substring(5,7));
		int day = Integer.parseInt(time.substring(8,10));
		int hour = Integer.parseInt(time.substring(11,13));
		int minute = Integer.parseInt(time.substring(14,16));
		int second = Integer.parseInt(time.substring(17,19));

		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			if(day>31||day<=0){
				return false;
			}
		}else if(month==4||month==6||month==9||month==11){
			if(day>30||day<=0){
				return false;
			}
		}else if(month==2){
			if(day>(thisYearFebHasDays(year))||day<=0){
				return false;
			}
		}else{
			return false;
		}

		if(hour>23||0>hour){
			return false;
		}
		if(minute>59||0>minute){
			int a = 123;
			return false;
		}
		if(second>59||0>second){
			return false;
		}

		return true;
	}


	/**
	 * ts字符串转换成long
	 * @author 许燊燊
	 * @throws ParseException
	 */
	public static long tsStrToLong(String dateTime) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf.parse(dateTime).getTime();
	}

	/**
	 * 根据日期取得星期几
	 * @author 许燊燊
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date){
		String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(week_index<0){
			week_index = 0;
		}
		return weeks[week_index];
	}

	/**
	 * 获取明天的时间
	 * @author 许燊燊
	 * @param date
	 * @return	Stirng
	 */
	public static String getLaterDate(String date){
		Calendar cal = Calendar.getInstance();
		String dateLater = "";
		try {
			cal.setTime(DateUtils.parseDate(date));
			cal.add(Calendar.DAY_OF_YEAR, +1);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			dateLater = formatter.format(cal.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateLater;
	}

	/**
	 * 获取昨天的时间
	 * @author 许燊燊
	 * @param date
	 * @return
	 */
	public static Date getYesterday(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		Date date1 = cal.getTime();
		return date1;
	}

	/**
	 * 获取N天后的日期
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getNDaysLaterDate(Date date,int n){
		Calendar cal = calendar();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, n);
		return cal.getTime();
	}

	/**
	 * 判断两个时间段是否有交集
	 * @param src_start_time
	 * @param src_end_time
	 * @param tar_start_time
	 * @param tar_end_time
	 * @return
	 */
	public static boolean isIntersection(String src_start_time, String src_end_time, String tar_start_time,String tar_end_time){

		long srcStartTime = DateUtils.strToTime(src_start_time);
		long srcEndTime = DateUtils.strToTime(src_end_time);

		long tarStartTime = DateUtils.strToTime(tar_start_time);
		long tarEndTime = DateUtils.strToTime(tar_end_time);

		if(srcStartTime < tarStartTime && srcEndTime <= tarStartTime){
			return false;
		}else if(srcStartTime >= tarEndTime && srcEndTime > tarEndTime){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * long --> HH:mm:ss
	 * 由于时区差异I,需要需要减去8小时
	 * @param time
	 */
	public static String longTimeToStr(long time){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(time - TimeZone.getDefault().getRawOffset());
	}

    public static int year(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    public static int month(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH);
    }

    //获得天所在月份的第一天
    public static String getFirstDayOfMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year(date));
        //设置月份
        cal.set(Calendar.MONTH, month(date));
        //设置日历中月份的第1天
        cal.set(Calendar.DAY_OF_MONTH, 1);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());

        return firstDayOfMonth ;
    }

    //获得天所在月份的最后一天
    public static String getLastDayOfMonth(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        //设置年份
        cale.set(Calendar.YEAR,year(date));
        cale.set(Calendar.MONTH, month(date)+1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        String lastday = format.format(cale.getTime());
        return lastday;
    }

	/**
	 * 获取N个月后的日期
	 * @param months
	 * @return
     */
	public static String getDateAfterMonths(Integer months){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c =Calendar.getInstance();
		c.add(Calendar.MONTH,months);

		return format.format(c.getTime());
	}

	/**
	 * 获取N个月后的时间
	 * @param months
	 * @return
	 */
	public static String getDateAfterDateTime(Integer months){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar c =Calendar.getInstance();
		c.add(Calendar.MONTH,months);

		return format.format(c.getTime());
	}

	public static void main(String[] args) throws ParseException {
        System.out.println(getFirstDayOfMonth(parseDate("2016-05-01")));
        System.out.println(getLastDayOfMonth(parseDate("2016-05-05 01:01:01")));
	}

}


