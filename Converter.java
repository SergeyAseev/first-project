select 
iit.priority,
iit.code,
oo.short_name 
from iommonitoring_iom_theme iit 
        join iommonitoring_control_points_iom icpi  
        on iit.id = icpi.iom_theme_id and icpi.delete_ts is null 
        and icpi.control_point_id = 'cf11d03a-7b5b-633a-363d-12037f090091' and icpi.excluded = false
        left join iommonitoring_iom_theme_responsible_org_link iitrol 
        on iitrol.iom_theme_id = iit.id
        left join orgs_org oo 
        on oo.id = iitrol.org_id 
where iit.delete_ts is null
order by iit.code;
