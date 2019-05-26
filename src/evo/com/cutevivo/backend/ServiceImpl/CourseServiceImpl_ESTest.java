/*
 * This file was automatically generated by EvoSuite
 * Sun May 26 09:20:53 GMT 2019
 */

package com.cutevivo.backend.ServiceImpl;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.Repository.BaseRepository;
import com.cutevivo.backend.Repository.CourseRepository;
import com.cutevivo.backend.Repository.NoteRepository;
import com.cutevivo.backend.ServiceImpl.CourseServiceImpl;
import com.cutevivo.backend.utils.ResultMessage;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CourseServiceImpl_ESTest extends CourseServiceImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      CourseServiceImpl courseServiceImpl0 = new CourseServiceImpl();
      CourseRepository courseRepository0 = new CourseRepository();
      BaseRepository baseRepository0 = new BaseRepository();
      Injector.inject(courseRepository0, (Class<?>) CourseRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(courseRepository0, (Class<?>) CourseRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "courseRepository", (Object) courseRepository0);
      NoteRepository noteRepository0 = new NoteRepository();
      BaseRepository baseRepository1 = mock(BaseRepository.class, new ViolatedAssumptionAnswer());
      doReturn((ResultMessage) null).when(baseRepository1).findByProperty(nullable(java.lang.Class.class) , anyString() , any());
      Injector.inject(noteRepository0, (Class<?>) NoteRepository.class, "baseRepository", (Object) baseRepository1);
      Injector.validateBean(noteRepository0, (Class<?>) NoteRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "noteRepository", (Object) noteRepository0);
      Injector.validateBean(courseServiceImpl0, (Class<?>) CourseServiceImpl.class);
      // Undeclared exception!
      try { 
        courseServiceImpl0.calcCourseScore((-1170L));
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.cutevivo.backend.ServiceImpl.CourseServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      CourseServiceImpl courseServiceImpl0 = new CourseServiceImpl();
      CourseRepository courseRepository0 = new CourseRepository();
      BaseRepository baseRepository0 = new BaseRepository();
      Injector.inject(courseRepository0, (Class<?>) CourseRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(courseRepository0, (Class<?>) CourseRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "courseRepository", (Object) courseRepository0);
      NoteRepository noteRepository0 = new NoteRepository();
      BaseRepository baseRepository1 = mock(BaseRepository.class, new ViolatedAssumptionAnswer());
      doReturn((ResultMessage) null).when(baseRepository1).findByProperty(nullable(java.lang.Class.class) , anyString() , any());
      Injector.inject(noteRepository0, (Class<?>) NoteRepository.class, "baseRepository", (Object) baseRepository1);
      Injector.validateBean(noteRepository0, (Class<?>) NoteRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "noteRepository", (Object) noteRepository0);
      Injector.validateBean(courseServiceImpl0, (Class<?>) CourseServiceImpl.class);
      ResultMessage resultMessage0 = courseServiceImpl0.getCourseNotes(0L);
      assertNull(resultMessage0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      CourseServiceImpl courseServiceImpl0 = new CourseServiceImpl();
      CourseRepository courseRepository0 = new CourseRepository();
      BaseRepository baseRepository0 = new BaseRepository();
      Injector.inject(courseRepository0, (Class<?>) CourseRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(courseRepository0, (Class<?>) CourseRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "courseRepository", (Object) courseRepository0);
      NoteRepository noteRepository0 = new NoteRepository();
      Injector.inject(noteRepository0, (Class<?>) NoteRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(noteRepository0, (Class<?>) NoteRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "noteRepository", (Object) noteRepository0);
      Injector.validateBean(courseServiceImpl0, (Class<?>) CourseServiceImpl.class);
      // Undeclared exception!
      try { 
        courseServiceImpl0.checkRepeat("A &x!2v");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.cutevivo.backend.Repository.BaseRepository", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      CourseServiceImpl courseServiceImpl0 = new CourseServiceImpl();
      CourseRepository courseRepository0 = new CourseRepository();
      BaseRepository baseRepository0 = new BaseRepository();
      Injector.inject(courseRepository0, (Class<?>) CourseRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(courseRepository0, (Class<?>) CourseRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "courseRepository", (Object) courseRepository0);
      NoteRepository noteRepository0 = new NoteRepository();
      Injector.inject(noteRepository0, (Class<?>) NoteRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(noteRepository0, (Class<?>) NoteRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "noteRepository", (Object) noteRepository0);
      Injector.validateBean(courseServiceImpl0, (Class<?>) CourseServiceImpl.class);
      Course course0 = new Course();
      // Undeclared exception!
      try { 
        courseServiceImpl0.deleteCourse(course0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.cutevivo.backend.Repository.BaseRepository", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      CourseServiceImpl courseServiceImpl0 = new CourseServiceImpl();
      CourseRepository courseRepository0 = new CourseRepository();
      BaseRepository baseRepository0 = new BaseRepository();
      Injector.inject(courseRepository0, (Class<?>) CourseRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(courseRepository0, (Class<?>) CourseRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "courseRepository", (Object) courseRepository0);
      NoteRepository noteRepository0 = new NoteRepository();
      Injector.inject(noteRepository0, (Class<?>) NoteRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(noteRepository0, (Class<?>) NoteRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "noteRepository", (Object) noteRepository0);
      Injector.validateBean(courseServiceImpl0, (Class<?>) CourseServiceImpl.class);
      // Undeclared exception!
      try { 
        courseServiceImpl0.getCourseNotes(0L);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.cutevivo.backend.Repository.BaseRepository", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      CourseServiceImpl courseServiceImpl0 = new CourseServiceImpl();
      // Undeclared exception!
      try { 
        courseServiceImpl0.getAllCourses();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.cutevivo.backend.ServiceImpl.CourseServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      CourseServiceImpl courseServiceImpl0 = new CourseServiceImpl();
      Course course0 = new Course();
      // Undeclared exception!
      try { 
        courseServiceImpl0.addCourse(course0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.cutevivo.backend.ServiceImpl.CourseServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      CourseServiceImpl courseServiceImpl0 = new CourseServiceImpl();
      CourseRepository courseRepository0 = new CourseRepository();
      BaseRepository baseRepository0 = new BaseRepository();
      Injector.inject(courseRepository0, (Class<?>) CourseRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(courseRepository0, (Class<?>) CourseRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "courseRepository", (Object) courseRepository0);
      NoteRepository noteRepository0 = new NoteRepository();
      Injector.inject(noteRepository0, (Class<?>) NoteRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(noteRepository0, (Class<?>) NoteRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "noteRepository", (Object) noteRepository0);
      Injector.validateBean(courseServiceImpl0, (Class<?>) CourseServiceImpl.class);
      // Undeclared exception!
      try { 
        courseServiceImpl0.getCourseByKeyword("Failed to get request URI: ");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.cutevivo.backend.Repository.BaseRepository", e);
      }
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      CourseServiceImpl courseServiceImpl0 = new CourseServiceImpl();
      CourseRepository courseRepository0 = new CourseRepository();
      BaseRepository baseRepository0 = new BaseRepository();
      Injector.inject(courseRepository0, (Class<?>) CourseRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(courseRepository0, (Class<?>) CourseRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "courseRepository", (Object) courseRepository0);
      NoteRepository noteRepository0 = new NoteRepository();
      Injector.inject(noteRepository0, (Class<?>) NoteRepository.class, "baseRepository", (Object) baseRepository0);
      Injector.validateBean(noteRepository0, (Class<?>) NoteRepository.class);
      Injector.inject(courseServiceImpl0, (Class<?>) CourseServiceImpl.class, "noteRepository", (Object) noteRepository0);
      Injector.validateBean(courseServiceImpl0, (Class<?>) CourseServiceImpl.class);
      // Undeclared exception!
      try { 
        courseServiceImpl0.getCourseById((-2133L));
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.cutevivo.backend.Repository.BaseRepository", e);
      }
  }
}