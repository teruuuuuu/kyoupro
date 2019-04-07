package topcoder.corporationsalary;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=9824&rd=12179
 */
public class CorporationSalary {
  public long totalSalary(String[] relations) {
//    CorporationSalary1 cs = new CorporationSalary1();
//    return cs.totalSalary(relations);
    CoporationSalaryWork cs = new CoporationSalaryWork(relations);
    return cs.total();
  }

  class CoporationSalaryWork {
    long[] salaries;
    String[] relations;
    public CoporationSalaryWork(String[] relations) {
      this.relations = relations;
      this.salaries = new long[relations.length];
    }

    public long total() {
      long total = 0;
      for(int i = 0; i < this.salaries.length; i++ ){
        total += this.salary(i);
      }
      return total;
    }

    private long salary(int i) {
      if(this.salaries[i] != 0){
        return this.salaries[i];
      } else {
        long s = 0;
        for(int j = 0; j < this.relations.length; j++ ) {
          if(this.relations[i].charAt(j) == 'Y'){
            s += salary(j);
          }
        }
        if(s == 0) {
          this.salaries[i] = 1;
        } else {
          this.salaries[i] = s;
        }
        return this.salaries[i];
      }
    }
  }


  class CorporationSalary1 {
    private long[] salaries;

    public long totalSalary(String[] relations) {
      salaries = new long[relations.length];
      long total = 0;
      for (int i = 0; i < relations.length; i++) {
        total += getSalary(i, relations);
      }
      return total;
    }

    private long getSalary(int i, String[] relations) {
      if (salaries[i] == 0) {
        long salary = 0;
        String relation = relations[i];
        for (int j = 0; j < relation.length(); j++) {
          if (relation.charAt(j) == 'Y') {
            salary += getSalary(j, relations);
          }
        }
        if (salary == 0) salary = 1;
        salaries[i] = salary;
      }
      return salaries[i];
    }
  }
}
