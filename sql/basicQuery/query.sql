# 查询此老师所有学生的成绩信息

SELECT student.id,
       student.name,
       course.name      as course,
       teacher.name     as teacher,
       clazz.name       as clazz,
       specialized.name as specialized,
       faculty.name     as faculty,
       elective.score   as score


FROM t_teacher teacher,
     t_teach teach,
     t_course course,
     t_elective elective,
     t_student student,
     t_clazz clazz,
     t_specialized specialized,
     t_faculty faculty


where teacher.id = 2
  AND teach.teacher = teacher.id
  AND teach.course = course.id
  AND elective.course = course.id
  AND elective.student = student.id
  AND student.clazz = clazz.id
  AND clazz.specialized = specialized.id
  AND specialized.faculty = faculty.id;


# 查询此老师所教的所有课程
SELECT course.name as course
from t_teacher teacher,
     t_teach teach,
     t_course course

where teacher.id = 2
  and teach.teacher = teacher.id
  and teach.course = course.id;

# 查询老师所教的院系
SELECT distinct faculty.name as faculty
FROM t_teacher teacher,
     t_teach teach,
     t_course course,
     t_elective elective,
     t_student student,
     t_clazz clazz,
     t_specialized specialized,
     t_faculty faculty
where teacher.id = 2
  AND teach.teacher = teacher.id
  AND teach.course = course.id
  AND elective.course = course.id
  AND elective.student = student.id
  AND student.clazz = clazz.id
  AND clazz.specialized = specialized.id
  AND specialized.faculty = faculty.id;

# 查询老师所教的 专业
SELECT distinct specialized.name as specialized
FROM t_teacher teacher,
     t_teach teach,
     t_course course,
     t_elective elective,
     t_student student,
     t_clazz clazz,
     t_specialized specialized,
     t_faculty faculty
where teacher.id = 2
  AND teach.teacher = teacher.id
  AND teach.course = course.id
  AND elective.course = course.id
  AND elective.student = student.id
  AND student.clazz = clazz.id
  AND clazz.specialized = specialized.id;

# 查询指定院系的所有专业
SELECT specialized.id, specialized.name
FROM t_specialized specialized,
     t_faculty faculty
where specialized.faculty = faculty.id
  and faculty.id = '1';

# 查询指定专业所有班级
SELECT clazz.id, clazz.name
FROM t_specialized specialized,
     t_clazz clazz
where clazz.specialized = specialized.id
  and specialized.id = '1';

# 查询指定班级指定老师所任教的课程
SELECT course.id, course.name
FROM t_teacher teacher,
     t_teach teach,
     t_course course,
     t_specialized specialized,
     t_clazz clazz

WHERE teacher.id = 2
  and clazz.id = 2
  and teach.teacher = teacher.id
  and teach.course = course.id
  and course.specialized = specialized.id
  and clazz.specialized = specialized.id