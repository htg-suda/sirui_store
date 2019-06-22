select SP.id
from sr_good_spu SP
         left join (select spu_id,
                           max(case when spec_item_name = ? then spec_value else '' end) ?,
                           max(case when spec_item_name = ? then spec_value else '' end) ?,
                           max(case when spec_item_name = ? then spec_value else '' end) ?,
                           max(case when spec_item_name = ? then spec_value else '' end) ?
                    from sr_spu_good_spec_value
                    where spec_item_name in (?, ?, ?, ?)) as VA on SP.id = VA.spu_id;


