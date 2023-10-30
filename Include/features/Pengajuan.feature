#Author: your.email@your.domain.com
#Feature: List of scenarios.
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @pengajuan1
  Scenario: Pengajuan Learning program
    Given I navigate to home page
    When I click Learning Wallet menu
    And I click Pengajuan Pelatihan dropdown
    And I click Pengajuan menu
    And I click Pengajuan Learning Program
    Then I should be able to open modul Form Pengajuan

  @pengajuan2
  Scenario: create form pengajuan
    Given I navigate to form pengajuan
    When I select job kopetensi field
    And I type deskripsi pengajuan field
    And I set nilai pengajuan field
    And I type Tujuan megajukan field
    And I type lokasi training field
    And I type vendor field
    And I upload bukti pengajuan
    And I click ceklist box
    And I click simpan button
    Then I successfully created pengajuan
