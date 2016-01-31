select
        category0_.ID_CATEGORY as ID_CATEG1_1_0_,
        category0_.DIFFICULTY as DIFFICUL2_1_0_,
        category0_.FULLNAME as FULLNAME3_1_0_,
        category0_.NAME as NAME4_1_0_,
        category0_.FK_PARENT_CATEGORY as FK_PARE10_1_0_,
        category0_.STATUS as STATUS5_1_0_,
        category0_.CREATED_BY as CREATED_6_1_0_,
        category0_.CREATED_DATE as CREATED_7_1_0_,
        category0_.MODIFIED_BY as MODIFIED8_1_0_,
        category0_.MODIFIED_DATE as MODIFIED9_1_0_,
        criterios1_.FK_ID_CATEGORY as FK_ID_C10_1_1_,
        criterios1_.ID_CRITERIO as ID_CRITE1_2_1_,
        criterios1_.ID_CRITERIO as ID_CRITE1_2_2_,
        criterios1_.FK_ID_CATEGORY as FK_ID_C10_2_2_,
        criterios1_.DESCRIPTION as DESCRIPT2_2_2_,
        criterios1_.HTML_FORM_ELEMENT as HTML_FOR3_2_2_,
        criterios1_.NAME as NAME4_2_2_,
        criterios1_.TYPE_CRITERIO as TYPE_CRI5_2_2_,
        criterios1_.CREATED_BY as CREATED_6_2_2_,
        criterios1_.CREATED_DATE as CREATED_7_2_2_,
        criterios1_.MODIFIED_BY as MODIFIED8_2_2_,
        criterios1_.MODIFIED_DATE as MODIFIED9_2_2_,
        criteriova2_.FK_ID_CRITERIO as FK_ID_CR5_2_3_,
        criteriova2_.ID_CRITERIO_VALUE as ID_CRITE1_5_3_,
        criteriova2_.ID_CRITERIO_VALUE as ID_CRITE1_5_4_,
        criteriova2_.FK_ID_CRITERIO as FK_ID_CR5_5_4_,
        criteriova2_.NAME as NAME2_5_4_,
        criteriova2_.TYPE_CRITERIO as TYPE_CRI3_5_4_,
        criteriova2_.TYPE_FIELD as TYPE_FIE4_5_4_,
        category3_.ID_CATEGORY as ID_CATEG1_1_5_,
        category3_.DIFFICULTY as DIFFICUL2_1_5_,
        category3_.FULLNAME as FULLNAME3_1_5_,
        category3_.NAME as NAME4_1_5_,
        category3_.FK_PARENT_CATEGORY as FK_PARE10_1_5_,
        category3_.STATUS as STATUS5_1_5_,
        category3_.CREATED_BY as CREATED_6_1_5_,
        category3_.CREATED_DATE as CREATED_7_1_5_,
        category3_.MODIFIED_BY as MODIFIED8_1_5_,
        category3_.MODIFIED_DATE as MODIFIED9_1_5_ 
    from
        CATEGORY category0_ 
    left outer join
        CRITERIO criterios1_ 
            on category0_.ID_CATEGORY=criterios1_.FK_ID_CATEGORY 
    left outer join
        CRITERIO_VALUE criteriova2_ 
            on criterios1_.ID_CRITERIO=criteriova2_.FK_ID_CRITERIO 
    left outer join
        CATEGORY category3_ 
            on category0_.FK_PARENT_CATEGORY=category3_.ID_CATEGORY 
    where
        category0_.ID_CATEGORY=?